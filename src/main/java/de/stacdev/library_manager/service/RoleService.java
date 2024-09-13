package de.stacdev.library_manager.service;

import de.stacdev.library_manager.entity.Role;
import de.stacdev.library_manager.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * @author Collins Souop
 */
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(Role role){
        return this.roleRepository.save(role);
    }
}
