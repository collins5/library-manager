package de.stacdev.library_manager.repository;

import de.stacdev.library_manager.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository
        extends JpaRepository<Permissions, Integer> {
}
