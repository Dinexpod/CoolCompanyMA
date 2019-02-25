package mate.academy.web;
import mate.academy.config.Factory;
import mate.academy.controllers.Controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static mate.academy.web.Request.RequestMethod.GET;
import static mate.academy.web.Request.RequestMethod.POST;
public class MainServlet extends HttpServlet {
    private final static Map<Request, Controller>  controllers = new HashMap<>();
    static {
        controllers.put(Request.of("/servlet/login", POST), Factory.getLoginController());
        controllers.put(Request.of("/servlet/login", GET), r -> ViewModel.of("login"));
        controllers.put(Request.of("/servlet/registration", POST), Factory.getRegistrationController());
        controllers.put(Request.of("/servlet/registration", GET), r -> ViewModel.of("registration"));
        controllers.put(Request.of("/servlet/home", GET), r -> ViewModel.of("home"));
        controllers.put(Request.of("/servlet/403", GET), r -> ViewModel.of("403"));
        controllers.put(Request.of("/servlet/404", GET), r -> ViewModel.of("404"));

        controllers.put(Request.of("/servlet/logout", Request.RequestMethod.GET), r -> ViewModel.of("logout"));
        controllers.put(Request.of("/servlet/logout", Request.RequestMethod.POST), Factory.getLogoutController());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }
    private void sedResponse(ViewModel vm, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String redirectUrl = "/WEB-INF/views/%s.jsp";
        vm.getModel().forEach(req::setAttribute);
        req.getRequestDispatcher(String.format(redirectUrl, vm.getView()))
                .forward(req, resp);
    }
    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getServletPath() + req.getPathInfo();
        Map<String, String[]> parameterMap = req.getParameterMap();
        Request r = Request.of(path, Request.RequestMethod.
                valueOf(req.getMethod()), parameterMap);

        Controller controller = controllers.getOrDefault(r,
                reqNotExist -> ViewModel.of("404)"));

        ViewModel vm = controller.process(r);

        if (!vm.getAllCookie().isEmpty()) {
            resp.addCookie(vm.getCookie());
        }
        sedResponse(vm, req, resp);
    }
}
