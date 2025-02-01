package uz.pdp.farmacy.controller;

import uz.pdp.farmacy.data.Customers;
import uz.pdp.farmacy.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    private CustomersService customerService;

    @GetMapping("/get-customers")
    public Iterable<Customers>getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/customers-by-id/{id}")
    public Customers getCustomerById(@PathVariable int id) {
        return customerService.findById(id);
    }

    @PostMapping("/customer-add")
    public void addCustomer(@RequestBody Customers customers) {
        customerService.addCustomer(customers);
    }

    @PutMapping("/customer-update/{id}")
    public String updateCustomer(@PathVariable int id,
                               @RequestBody Customers customers) {
        return customerService.updateUserById(id, customers);
    }

    @DeleteMapping("/customer-delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return customerService.deleteUserById(id);
    }


}
