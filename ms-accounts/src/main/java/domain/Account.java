package domain;

import jakarta.persistence.*;
import enums.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @OneToMany(mappedBy = "accountNumber", cascade = CascadeType.ALL)
    private String accountNumber;

    private AccountType accountType;

    @Column(nullable = false)
    private BigDecimal balance;

    private Boolean status;
    private String client;


}
