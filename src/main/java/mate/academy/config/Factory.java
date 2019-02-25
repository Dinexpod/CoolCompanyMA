package mate.academy.config;

import mate.academy.ConnectionUtil;
import mate.academy.controllers.LoginController;
import mate.academy.controllers.LogoutController;
import mate.academy.controllers.RegistrationController;
import mate.academy.dao.RoleDao;
import mate.academy.dao.RoleDaoImpl;
import mate.academy.dao.UserDao;
import mate.academy.dao.UserDaoImpl;
import mate.academy.services.RoleService;
import mate.academy.services.RoleServiceImpl;
import mate.academy.services.SecurityService;
import mate.academy.services.SecurityServiceImpl;
import mate.academy.services.UserService;
import mate.academy.services.UserServiceImpl;

import java.sql.Connection;

public class Factory {

    private static final Connection CONNECTION;

    static {
        CONNECTION = ConnectionUtil.getConnection();
    }

    private Factory() {
    }

    public static LoginController getLoginController() {
        return new LoginController(getSecurityService());
    }

    public static LogoutController getLogoutController() {
        return new LogoutController();
    }

    public static RegistrationController getRegistrationController() {
        return new RegistrationController(getSecurityService());
    }

    public static SecurityService getSecurityService() {
        return new SecurityServiceImpl(getUserService());
    }

    public static UserService getUserService() {
        return new UserServiceImpl(getUserDao());
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl(CONNECTION);
    }

    public static RoleService getRoleService() {
        return new RoleServiceImpl(getRoleDao());
    }

    private static RoleDao getRoleDao() {
        return new RoleDaoImpl(CONNECTION);
    }
}
