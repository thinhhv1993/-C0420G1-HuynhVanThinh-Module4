package furama.service;

import furama.model.Role;

public interface RoleService {
    Role findByRoleName(String role_name);
}
