package mate.academy.controllers;

import mate.academy.web.Request;
import mate.academy.web.ViewModel;

import javax.servlet.http.Cookie;

public class LogoutController implements Controller {

    @Override
    public ViewModel process(Request request) {
        Cookie cookie = new Cookie("MATE", "");
        cookie.setMaxAge(0);
        ViewModel vm = ViewModel.of("login");
        vm.addCookie(cookie);
        return vm;
    }
}
