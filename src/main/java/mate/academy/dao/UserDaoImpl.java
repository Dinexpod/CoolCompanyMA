package mate.academy.dao;

import mate.academy.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addUser(User user) {
        final String INSERT = "INSERT INTO users(login, email, password, name, token) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setString(5, getRandomToken());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserById(User user) {
        final String UPDATE =
                "UPDATE users SET login=?, email=?, password=?, name=? WHERE user_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setLong(5, user.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserById(Long id) {
        final String DEL = "DELETE FROM users WHERE user_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(DEL);
            statement.setLong(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Long id) {
        final String SELECT = "SELECT * FROM users WHERE user_id = " + id + "";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT);

            return rs.next() ? getUser(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setLogin(rs.getString("login"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setToken(rs.getString("token"));

        return user;
    }

    @Override
    public List<User> showAllUsers() {
        final String FIND_ALL = "SELECT * FROM users";

        List<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = getUser(rs);
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getByUsername(String login) {
        final String SELECT = "SELECT * FROM users WHERE login = ?";

        return doStatement(SELECT, login);
    }

    @Override
    public User findByToken(String token) {
        final String TOKEN =
                "SELECT user_id, login, email, password, name, token FROM users WHERE token = ?";

        return doStatement(TOKEN, token);
    }

    private String getRandomToken() {
        return UUID.randomUUID().toString();
    }

    User doStatement(String query, String paramether) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, paramether);
            ResultSet rs = statement.executeQuery();

            return rs.next() ? getUser(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
