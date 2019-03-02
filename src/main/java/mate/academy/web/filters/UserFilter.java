package mate.academy.web.filters;

import mate.academy.config.Factory;
import mate.academy.dao.UserDao;
import mate.academy.models.Role;
import mate.academy.models.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserFilter implements Filter {

    private UserDao userDao;
    private Map<String, String> protectedUrls = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) {
        userDao = Factory.getUserDao();
        protectedUrls.put("servlet/admin", "ADMIN");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Cookie[] cookies = req.getCookies();
        String token = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("MATE")
                        && (c.getName() != null && !c.getValue().equals(""))) {
                    token = c.getValue();
                }
            }
        }

        String path = req.getServletPath() + req.getPathInfo();

        if (token == null) {
            if (path.equals("/servlet/login")
                    || path.equals("/servlet/registration")) {
                processAuth(req, resp, filterChain);
            } else {
                prosessUnauth(req, resp);
            }
        } else {
            User u = userDao.findByToken(token);

            if (u == null) {
                prosessUnauth(req, resp);
            } else {
                if (path.equals("/servlet/login") || path.equals("/servlet/registration")) {
                    resp.sendRedirect("/servlet/home");
                }

                if (verifyRole(u, path)) {
                    processAuth(req, resp, filterChain);
                }

                processDenied(servletRequest, servletResponse);
            }
        }
    }

    private void processDenied(ServletRequest servletRequest,
                               ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.getRequestDispatcher("/WEB-INF/views/403.jsp").forward(servletRequest, servletResponse);

    }

    private boolean verifyRole(User user, String path) {
        String role = protectedUrls.get(path);

        if (role == null)
            return true;

        for (Role r : user.getRoles()) {
            if (role.equals(r.getRole())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void destroy() {

    }

    private void prosessUnauth(HttpServletRequest req,
                               HttpServletResponse resp)
            throws ServletException, IOException {
        String redirectUrl = "/WEB-INF/views/login.jsp";
        req.getRequestDispatcher(redirectUrl).forward(req, resp);
    }

    private void processAuth(HttpServletRequest req,
                             HttpServletResponse resp,
                             FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(req, resp);
    }
}
