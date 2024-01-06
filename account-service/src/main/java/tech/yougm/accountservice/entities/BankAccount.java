package tech.yougm.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import tech.yougm.accountservice.enums.AccountType;
import tech.yougm.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type ;
    @Transient
    private Customer customer;
    private Long customerId;
}
