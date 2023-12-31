package tech.yougm.accountservice.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.yougm.accountservice.clients.CustomerRestClient;
import tech.yougm.accountservice.entities.BankAccount;
import tech.yougm.accountservice.model.Customer;
import tech.yougm.accountservice.repositories.BankAccountRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public BankAccountController(BankAccountRepository bankAccountRepository , CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/bankaccounts")
    public List<BankAccount> bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankaccounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount= bankAccountRepository.findById(id).orElse(null);
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());

            bankAccount.setCustomer(customer);
            return bankAccount;

    }

    // to do delete and save refactore all the request with the best practices and handling exception
}
