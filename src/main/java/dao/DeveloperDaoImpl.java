package dao;

import models.Developer;
import models.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDaoImpl extends AbstractDao implements DeveloperDao {
    public DeveloperDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addDeveloper(Developer developer) {
        final String INSERT = "INSERT INTO developers(name, age,salary) VALUES(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDeveloperById(Developer developer) {
        final String UPDATE =
                "UPDATE developers SET name=?, age=?, salary=? WHERE developer_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.setLong(4, developer.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDeveloperById(Long id) {
        final String DEL = "DELETE FROM developers WHERE developer_id=?";
        final String DEL_FROM_PROJECT = "DELETE FROM developers_projects WHERE developer_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(DEL);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DEL_FROM_PROJECT);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer getDeveloperById(Long id) {
        final String SELECT = "SELECT * FROM developers WHERE developer_id = " + id + "";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT);
            return rs.next() ? getDeveloper(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Developer getDeveloper(ResultSet rs) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getLong("developer_id"));
        developer.setName(rs.getString("name"));
        developer.setAge(rs.getInt("age"));
        developer.setSalary(rs.getDouble("salary"));

        return developer;
    }

    @Override
    public List<Developer> showAllDevelopers() {
        final String FIND_ALL = "SELECT * FROM developers";

        List<Developer> developers = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Developer developer = getDeveloper(rs);
                developers.add(developer);
            }

            return developers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developers;
    }

    @Override
    public void getAllDevelopersBySkillName(Skill skill) {
        System.out.print("\n\n List developers: ");

        final String GET_ALL_DEVS_BY_NAME_SKILL =
                "SELECT name " +
                        "FROM developers " +
                        "where developer_id IN " +
                        "      (select developers_skills.developer " +
                        "       from developers_skills " +
                        "       where developers_skills.skill IN " +
                        "             (select skill_id " +
                        "              from skills " +
                        "              where skills.name = ?) " +
                        "      )" +
                        ";";

        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_DEVS_BY_NAME_SKILL);
            statement.setString(1, skill.getName().name());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.print((rs.getString("name")) + ", ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllDevelopersBySkillDegree(Skill skill) {
        System.out.print("\n\n List developers: ");

        final String GET_ALL_DEVS_BY_DEGREE_SKILL =
                "SELECT name " +
                        "FROM developers " +
                        "where developer_id IN " +
                        "      (select developers_skills.developer " +
                        "       from developers_skills " +
                        "       where developers_skills.skill IN " +
                        "             (select skill_id " +
                        "              from skills " +
                        "              where skills.degree = ?) " +
                        "      )" +
                        ";";

        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_DEVS_BY_DEGREE_SKILL);
            statement.setString(1, skill.getDegree().name());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.print((rs.getString("name")) + ", ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
