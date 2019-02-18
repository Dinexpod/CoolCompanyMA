package mate.academy.services;

import mate.academy.models.User;
import mate.academy.web.ViewModel;

public interface SecurityService {

    ViewModel doLogin(String login, String password);

    boolean doReg(User user);
}
