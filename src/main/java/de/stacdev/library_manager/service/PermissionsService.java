package de.stacdev.library_manager.service;

import de.stacdev.library_manager.entity.Permissions;
import de.stacdev.library_manager.repository.PermissionsRepository;
import org.springframework.stereotype.Service;

/**
 * @author Collins Souop
 */
@Service
public class PermissionsService {
    private final PermissionsRepository permissionsRepository;

    public PermissionsService(final PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }

    public Permissions save(Permissions permissions) {
        return this.permissionsRepository
                .save(permissions);
    }
}
