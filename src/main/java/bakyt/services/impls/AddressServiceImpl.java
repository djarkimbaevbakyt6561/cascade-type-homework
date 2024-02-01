package bakyt.services.impls;

import bakyt.dao.AddressDao;
import bakyt.dao.impls.AddressDaoImpl;
import bakyt.entities.Address;
import bakyt.services.AddressService;
import bakyt.services.GeneralService;

import java.util.Optional;

public class AddressServiceImpl implements AddressService, GeneralService<Address> {
    AddressDaoImpl addressDao = new AddressDaoImpl();
    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressDao.getAddressById(id);
    }

    @Override
    public void save(Address address) {
        addressDao.save(address);
    }

    @Override
    public void update(Long id, Address address) {
        addressDao.update(id, address);
    }

    @Override
    public void delete(Long id) {
      addressDao.delete(id);
    }
}
