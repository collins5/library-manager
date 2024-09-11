package de.stacdev.library_manager.repository;

import de.stacdev.library_manager.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository
extends JpaRepository<Address, Integer> {
}
