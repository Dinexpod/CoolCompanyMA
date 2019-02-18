package controllers;

import mate.academy.controllers.Controller;
import mate.academy.web.Request;
import mate.academy.web.ViewModel;

public class LoginController implements Controller {

    @Override
    public ViewModel process(Request request) {
        ViewModel viewModel = new ViewModel("login");
        return viewModel;
    }
}
