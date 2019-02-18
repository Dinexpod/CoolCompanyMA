package mate.academy.controllers;

import mate.academy.web.Request;
import mate.academy.web.ViewModel;

public interface Controller {

    ViewModel process(Request request);
}
