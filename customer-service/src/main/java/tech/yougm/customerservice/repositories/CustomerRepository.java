package tech.yougm.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.yougm.customerservice.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
