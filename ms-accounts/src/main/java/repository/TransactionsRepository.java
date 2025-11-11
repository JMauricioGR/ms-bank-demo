package repository;

import domain.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findAllByAccount_AccountNumberAndDateBetween(String accountNumber, LocalDateTime from, LocalDateTime until);
    List<Transactions> findAllByAccount_AccountNumberOrderByDatesDesc(String accountNumber);
}
