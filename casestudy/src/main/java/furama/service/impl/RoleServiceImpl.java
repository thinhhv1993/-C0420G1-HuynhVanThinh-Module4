package furama.service.impl;

import furama.model.Role;
import furama.repository.RoleRepository;
import furama.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String role_name) {
        return this.roleRepository.findByRoleName(role_name);
    }
}
