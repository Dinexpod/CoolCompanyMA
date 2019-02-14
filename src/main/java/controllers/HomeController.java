package controllers;

import web.ViewModel;

public class HomeController implements Controller {
    @Override
    public ViewModel process() {
        ViewModel viewModel = new ViewModel("home");
        return viewModel;
    }
}
