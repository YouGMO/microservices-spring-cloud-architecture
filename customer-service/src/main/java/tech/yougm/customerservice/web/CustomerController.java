package tech.yougm.customerservice.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.yougm.customerservice.entities.Customer;
import tech.yougm.customerservice.repositories.CustomerRepository;

import java.util.List;

@RestController @AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer;
    }

    @GetMapping("/customers")
    public List<Customer> listCustomers(){
        return customerRepository.findAll();
    }

    //public Customer saveCustomer(Customer customer){}
}
