package controllers;

import web.ViewModel;

public class LoginController implements Controller {

    @Override
    public ViewModel process() {
        ViewModel viewModel = new ViewModel("login");
        return viewModel;
    }
}
