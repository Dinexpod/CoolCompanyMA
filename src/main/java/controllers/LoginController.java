package controllers;

import web.ViewModel;

public class LoginController implements Controller {
    @Override
    public ViewModel process() {
        String username = "Bill";

        ViewModel viewModel = new ViewModel("login");
        viewModel.getModel().put("username", username);
        return viewModel;
    }
}
