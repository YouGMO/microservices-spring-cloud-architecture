package tech.yougm.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.yougm.accountservice.entities.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
