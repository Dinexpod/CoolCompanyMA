package mate.academy.services;

import mate.academy.models.Role;

import java.util.List;

public interface RoleService {

    Long createRole(Role role);

    Role findById(Long id);

    List<Role> findAllByUserId(Long id);

    void updateRole(Role role);

    void deleteRoleById(Long id);

    void deleteAllRolesFromUser(Long userId);
}