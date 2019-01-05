package dao;

import models.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class DeveloperDaoImpl extends AbstractDao implements DeveloperDao {
    public DeveloperDaoImpl(Connection connection) {
        super(connection);
    }

    private final static String INSERT = "INSERT INTO developers(name, age,salary) VALUES(?,?,?)";
    // WARNING +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private final static String GET_LAST_INSERTED = "SELECT LAST_INSERT_ID()";



    private static final String SAVE_SKILLS = "INSERT developers_skills VALUES (?,?)";

    private final static String FIND_BY_ID = "SELECT * FROM developers WHERE ID = ?";

    private final static String UPDATE = "UPDATE developers SET name = ?, company_id = ?,project_id = ?,salary =? WHERE ID = ?";

    private final static String DELETE = "DELETE FROM developers WHERE ID = ?";

    private final static String DELETE_SKILLS = "DELETE FROM developers_skills WHERE developer_id = ?";

    private final static String FIND_ALL = "SELECT * FROM developers";

    private final static String FIND_BY_NAME = "SELECT * FROM developers WHERE NAME = ?";


    @Override
    public void addDeveloper(Developer developer) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.execute();

            statement = connection.prepareStatement(GET_LAST_INSERTED);
            statement.executeQuery();
            ResultSet set = statement.getResultSet();
            Long lastInsertIndex = set.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDeveloperById(Developer developer) {

    }

    @Override
    public void deleteDeveloperById(Long id) {

    }

    @Override
    public Developer getDeveloperById(Long id) {
        final String SELECT_DEVELOPER_BY_ID = "SELECT * FROM DEVELOPERS WHERE developer_id = " + id + "";
        Developer developer = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_DEVELOPER_BY_ID);
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
    public Set<Developer> showAllDevelopers() {
        return null;
    }
}
