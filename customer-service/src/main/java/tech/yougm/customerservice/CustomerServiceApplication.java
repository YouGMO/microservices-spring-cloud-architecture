package tech.yougm.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.yougm.customerservice.entities.Customer;
import tech.yougm.customerservice.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().firstName("youssef")
                    .lastName("gm").
                    email("gmyoussef@gmail.com").
                    build());
            customerRepository.save(Customer.builder().firstName("khalid")
                    .lastName("gm").
                    email("gmkhalid@gmail.com").
                    build());
            customerRepository.save(Customer.builder().firstName("othmane")
                    .lastName("gm").
                    email("gmothmane@gmail.com").
                    build());
        };
    }
}
