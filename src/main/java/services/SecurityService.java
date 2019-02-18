package services;

import models.User;

public interface SecurityService {
    boolean doLog(String login, String password);

    boolean doReg(User user);
}
