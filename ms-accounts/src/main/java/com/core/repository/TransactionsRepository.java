package com.core.repository;

import com.core.domain.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findAllByAccount_ClientAndDateBetween(String client, LocalDateTime from, LocalDateTime until);
    List<Transactions> findAllByAccount_AccountNumberOrderByDateDesc(String accountNumber);
}
