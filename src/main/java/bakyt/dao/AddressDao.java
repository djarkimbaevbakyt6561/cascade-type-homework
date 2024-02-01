package bakyt.dao;

import bakyt.entities.Address;

import java.util.Optional;

public interface AddressDao {
    Optional<Address> getAddressById(Long id);
}
