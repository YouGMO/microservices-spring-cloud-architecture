package tech.yougm.accountservice.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.yougm.accountservice.entities.BankAccount;
import tech.yougm.accountservice.repositories.BankAccountRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BankAccountController {

    private BankAccountRepository bankAccountRepository;

    @GetMapping("/bankaccounts")
    public List<BankAccount> bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankaccounts/{id}")
    public Optional<BankAccount> bankAccountById(@PathVariable String id){
        return bankAccountRepository.findById(id);
    }

    // to do delete and save refactore all the request with the best practices and handling exception
}
