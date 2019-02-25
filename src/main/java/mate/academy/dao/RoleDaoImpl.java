package mate.academy.dao;

import mate.academy.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl extends AbstractDao implements RoleDao {

    public RoleDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Long createRole(Role role) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO roles(name)" +
                    "VALUES ?");
            statement.setString(1, role.getRole());
            statement.execute();

            statement = connection.prepareStatement("SELECT MAX(role_id) FROM roles");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getLong("role_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role findById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT role_id, name " +
                    "FROM roles WHERE role_id = ?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return new Role(rs.getLong("role_id"), rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> findAllByUserId(Long id) {
        List<Role> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT coolcompany.users.user_id, roles.role_id, roles.name " +
                            "FROM roles " +
                            "JOIN user_role ON (roles.role_id = user_role.role) " +
                            "JOIN users ON (users.user_id = user_role.user) " +
                            "HAVING user_id = ?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                list.add(new Role(rs.getLong("role_id"), rs.getString("name")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateRole(Role role) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE roles" +
                    " name = ? WHERE role_id = ?");
            statement.setString(1, role.getRole());
            statement.setLong(2, role.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM roles " +
                    "WHERE role_id = ?");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllRolesFromUser(Long userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM user_role" +
                    " WHERE user_role.user = ?");
            statement.setLong(1, userId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}