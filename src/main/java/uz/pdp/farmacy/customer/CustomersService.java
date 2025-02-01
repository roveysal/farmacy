package uz.pdp.farmacy.service;

import uz.pdp.farmacy.data.Customers;
import uz.pdp.farmacy.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    public Iterable<Customers> findAll() {
        return customersRepository.findAll();
    }

    public Customers findById(int id) {
        return customersRepository
                .findById(id)
                .orElse(null);

    }

    public void addCustomer(Customers customers) {
        customersRepository.save(customers);
    }

    public String updateUserById(Integer id, Customers customers) {

        Customers customerById = findById(id);

        if (customerById.getId() == id) {

            customersRepository.save(customers);

            return "SUCCESS UPDATED!";
        }
        return "FAILED UPDATED!";
    }

    public String deleteUserById(Integer id) {
        boolean isExists = customersRepository.existsById(id);
        if (isExists) {
            customersRepository.deleteById(id);
            return "SUCCESS DELETED!";
        }
        return "FAILED DELETED!";
    }

}
