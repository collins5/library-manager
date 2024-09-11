package de.stacdev.library_manager.repository;

import de.stacdev.library_manager.entity.Role_Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Role_PermissionsRepository
extends JpaRepository<Role_Permissions, Integer> {
}
