package domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String transaction;
    private BigDecimal amount;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
}
