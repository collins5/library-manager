package de.stacdev.library_manager.repository;

import de.stacdev.library_manager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository
        extends JpaRepository<Role, Integer> {
}
