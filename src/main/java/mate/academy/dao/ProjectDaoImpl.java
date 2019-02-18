package mate.academy.dao;

import mate.academy.models.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectDaoImpl extends AbstractDao implements ProjectDao {
    int companyId = 1;

    public ProjectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addProject(Project project) {
        final String INSERT = "INSERT INTO projects(type, name, cost) VALUES(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, project.getType());
            statement.setString(2, project.getName());
            statement.setDouble(3, project.getCost());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProjectById(Project project) {
        final String UPDATE =
                "UPDATE projects SET type=?, name=?, cost=? WHERE project_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, project.getType());
            statement.setString(2, project.getName());
            statement.setDouble(3, project.getCost());
            statement.setLong(4, project.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProjectById(Long id) {
        final String DEL = "DELETE FROM projects WHERE project_id=?";
        final String DEL_FROM_COMPANY = "DELETE FROM companies_projects WHERE project=?";
        final String DEL_FROM_CUSTOMER = "DELETE FROM customers_projects WHERE project=?";
        final String DEL_FROM_DEVELOPER = "DELETE FROM developers_projects WHERE project=?";

        try {
            PreparedStatement statement = connection.prepareStatement(DEL);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DEL_FROM_DEVELOPER);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DEL_FROM_CUSTOMER);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DEL_FROM_COMPANY);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getProjectById(Long id) {
        final String SELECT = "SELECT * FROM projects WHERE project_id = " + id + "";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT);
            return rs.next() ? getProject(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Project getProject(ResultSet rs) throws SQLException {
        Project project = new Project();
        project.setId(rs.getLong("project_id"));
        project.setType(rs.getString("type"));
        project.setName(rs.getString("name"));
        project.setCost(rs.getDouble("cost"));

        return project;
    }

    @Override
    public List<Project> showAllProjects() {
        final String FIND_ALL = "SELECT * FROM projects";

        List<Project> projects = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Project project = getProject(rs);
                projects.add(project);
            }

            return projects;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projects;
    }

    @Override
    public int showSomeDevs() {
        int count = 0;
        final String FIND_ALL = "SELECT name " +
                "FROM developers " +
                "where developer_id IN " +
                "      (select developers_projects.developer " +
                "       from developers_projects " +
                "       where developers_projects.project IN " +
                "             (select project_id " +
                "             from projects " +
                "             where project_id = ?) " +
                "      )" +
                ";";

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            statement.setLong(1, companyId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ++count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ++companyId;
        return count;
    }

    @Override
    public Double getAllSalaryFromProject(Project project) {
        Double sumSalary = null;
        System.out.print("\nAll salary: ");

        final String GET_SUM_FROM_PROJECT =
                "SELECT sum(salary) AS sumSalary " +
                        "FROM developers " +
                        "where developer_id IN " +
                        "      (select developers_projects.developer " +
                        "       from developers_projects " +
                        "       where developers_projects.project IN " +
                        "             (select project_id " +
                        "             from projects" +
                        "             where project_id = ?) " +
                        "      )" +
                        ";";

        try {
            PreparedStatement statement = connection.prepareStatement(GET_SUM_FROM_PROJECT);
            statement.setLong(1, project.getId());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                sumSalary = rs.getDouble("sumSalary");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sumSalary;
    }

    @Override
    public void getAllDevelopersFromProject(Project project) {
        System.out.print("\n\n List users: ");

        final String GET_ALL_DEVS_FROM_PROJECT =
                "SELECT developers.name " +
                        "FROM developers " +
                        "where developer_id IN " +
                        "      (select developers_projects.developer " +
                        "       from developers_projects " +
                        "       where developers_projects.project IN " +
                        "             (select project_id " +
                        "             from projects " +
                        "             where project_id = ?) " +
                        "      )" +
                        ";";

        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_DEVS_FROM_PROJECT);
            statement.setLong(1, project.getId());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.print(Collections.singletonList((rs.getString("name"))) + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
