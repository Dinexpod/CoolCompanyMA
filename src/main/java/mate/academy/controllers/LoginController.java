package mate.academy.controllers;

import mate.academy.services.SecurityService;
import mate.academy.web.PassEncoder;
import mate.academy.web.Request;
import mate.academy.web.ViewModel;

public class LoginController implements Controller {
    private SecurityService securityService;

    public LoginController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public ViewModel process(Request request) {
        String login = request.getParamByName("login");
        String actualPass = PassEncoder.encode(request.getParamByName("password"));

        return securityService.doLog(login, actualPass);
    }
}
