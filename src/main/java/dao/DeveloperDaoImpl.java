package dao;

import models.Developer;

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
        final  String INSERT = "INSERT INTO developers(name, age,salary) VALUES(?,?,?)";

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
//??????????????????????????????????????????????
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
}
