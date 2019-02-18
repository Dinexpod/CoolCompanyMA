package mate.academy.services;

import mate.academy.models.User;
import mate.academy.web.ViewModel;

import javax.servlet.http.Cookie;

public class SecurityServiceImpl implements SecurityService {

    private final UserService userService;

    public SecurityServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel doLog(String login, String password) {

        User user = userService.getByUsername(login);

        if (user == null || !(user.getPassword().equals(password))) {
            return processUnAuth();
        }

        return processAuth(user);
    }

    @Override
    public boolean doReg(User user) {
        userService.addUser(user);
        return true;
    }

    private ViewModel processAuth(User user) {
        String userToken = user.getToken();
        Cookie cookie = new Cookie("MATE", userToken);
        ViewModel vm = new ViewModel("home");
        vm.addCookie(cookie);
        return vm;
    }

    private ViewModel processUnAuth() {
        ViewModel vm = new ViewModel("login");
        vm.addAttribute("err", "Incorrect pass or log");
        return ViewModel.of("login");
    }
}
