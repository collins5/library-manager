package de.stacdev.library_manager.repository;

import de.stacdev.library_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Collins Souop
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
