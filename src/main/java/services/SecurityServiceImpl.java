package services;

import models.User;

public class SecurityServiceImpl implements SecurityService {

    private final UserService userService;

    public SecurityServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean doLog(String login, String password) {
        User user = userService.getByUsername(login);
        return user.getPassword().equals(password);
    }

    @Override
    public boolean doReg(User user) {
        userService.addUser(user);
        return true;
    }
}
