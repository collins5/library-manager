package de.stacdev.library_manager.service;

import de.stacdev.library_manager.entity.Address;
import de.stacdev.library_manager.repository.AddressRepository;
import org.springframework.stereotype.Service;

/**
 * @author Collins Souop
 */
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        return this.addressRepository
                .save(address);
    }
}
