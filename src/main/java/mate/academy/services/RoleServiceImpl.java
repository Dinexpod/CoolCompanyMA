package mate.academy.services;

import mate.academy.dao.RoleDao;
import mate.academy.models.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Long createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findAllByUserId(Long id) {
        return roleDao.findAllByUserId(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleDao.deleteRoleById(id);
    }

    @Override
    public void deleteAllRolesFromUser(Long userId) {
        roleDao.deleteAllRolesFromUser(userId);
    }
}