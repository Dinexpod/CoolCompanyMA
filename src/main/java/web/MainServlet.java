package web;

import controllers.Controller;
import controllers.HomeController;
import controllers.LoginController;
import controllers.RegistrationController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static web.Request.RequestMethod.GET;

public class MainServlet extends HttpServlet {

  private final static Map<Request, Controller>  controllers = new HashMap<>();

    static {
        controllers.put(Request.of("/servlet/login", GET), new LoginController());
        controllers.put(Request.of("/servlet/", GET), new HomeController());
        controllers.put(Request.of("/servlet/registration", GET), new RegistrationController());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getServletPath() + req.getPathInfo();
        Request r = Request.of(path, Request.RequestMethod.valueOf(req.getMethod()));
        Controller controller = controllers.get(r);
        ViewModel vm = controller.process();
        sedResponse(vm, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void sedResponse(ViewModel vm, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String redirectUrl = "/WEB-INF/views/%s.jsp";
        vm.getModel().forEach(req::setAttribute);
        req.getRequestDispatcher(String.format(redirectUrl, vm.getView()))
                .forward(req, resp);
    }
}
