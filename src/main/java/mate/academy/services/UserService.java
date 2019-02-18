package mate.academy.services;

import mate.academy.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUserById(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

    List<User> showAllUsers();

    User getByUsername(String login);
}
