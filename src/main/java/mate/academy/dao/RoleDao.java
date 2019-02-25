package mate.academy.dao;

import mate.academy.models.Role;

import java.util.List;

public interface RoleDao {

    Long createRole(Role role);

    Role findById(Long id);

    List<Role> findAllByUserId(Long id);

    void updateRole(Role role);

    void deleteRoleById(Long id);

    void deleteAllRolesFromUser(Long userId);
}