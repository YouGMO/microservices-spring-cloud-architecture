package tech.yougm.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.yougm.accountservice.entities.BankAccount;
import tech.yougm.accountservice.enums.AccountType;
import tech.yougm.accountservice.repositories.BankAccountRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {
            BankAccount bankAccount = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(50000)
                    .currency("EURO")
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT)
                    .customerId(1L)
                    .build();
            BankAccount bankAccount3 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(10000)
                    .currency("EURO")
                    .createdAt(LocalDate.now())
                    .type(AccountType.SAVING)
                    .customerId(3L)
                    .build();
            BankAccount bankAccount2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(40000)
                    .currency("EURO")
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT)
                    .customerId(2L)
                    .build();
            bankAccountRepository.save(bankAccount);
            bankAccountRepository.save(bankAccount2);
            bankAccountRepository.save(bankAccount3);

        };

    }
}
