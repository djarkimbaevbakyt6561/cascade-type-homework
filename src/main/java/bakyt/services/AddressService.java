package bakyt.services;

import bakyt.entities.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> getAddressById(Long id);
}
