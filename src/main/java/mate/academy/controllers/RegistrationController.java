package mate.academy.controllers;

import mate.academy.models.User;
import mate.academy.services.SecurityService;
import mate.academy.web.PassEncoder;
import mate.academy.web.Request;
import mate.academy.web.ViewModel;

public class RegistrationController implements Controller {

    private SecurityService securityService;

    public RegistrationController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public ViewModel process(Request request) {
        String password = PassEncoder.encode(request.getParamByName("password"));
        String login = request.getParamByName("login");
        String name = request.getParamByName("name");
        String email = request.getParamByName("email");

        User user = new User(login, name, password, email);

        securityService.doReg(user);

        return ViewModel.of("login");
    }
}
