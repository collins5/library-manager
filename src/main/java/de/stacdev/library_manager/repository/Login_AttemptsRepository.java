package de.stacdev.library_manager.repository;

import de.stacdev.library_manager.entity.Login_Attempts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Login_AttemptsRepository
extends JpaRepository<Login_Attempts, Integer> {
}
