package com.core.service;

import com.core.domain.Account;
import com.core.domain.Transactions;
import com.core.dtos.response.TransactionResponseDto;
import com.core.enums.TransactionsType;
import com.core.exceptions.AmmountException;
import com.core.mappers.TransactionsMapper;
import org.springframework.stereotype.Service;
import com.core.repository.AccountsRepository;
import com.core.repository.TransactionsRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final TransactionsRepository transactionRepo;
    private final AccountsRepository accountRepo;

    public TransactionService(TransactionsRepository transactionRepo, AccountsRepository accountRepo){
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    public TransactionResponseDto createTransaction(String accountNumber, BigDecimal amount){
        Account account = accountRepo.findByAccountNumber(accountNumber);

        BigDecimal newAmount = account.getBalance().add(amount);
        if (newAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new AmmountException("Saldo no disponible");
        }
        Transactions transaction = new Transactions();
        transaction.setAccount(account);
        transaction.setDate(LocalDateTime.now());
        transaction.setAmount(amount);
        transaction.setAmount(newAmount);
        transaction.setTransactionType(amount.signum() >= 0 ? TransactionsType.DEPOSITO : TransactionsType.RETIRO);

        account.setBalance(newAmount);
        accountRepo.save(account);
        return TransactionsMapper.responseTransactionsToDto(transactionRepo.save(transaction));
    }

    public List<TransactionResponseDto> transactionsByClientAndDateRange(String client, LocalDateTime from, LocalDateTime until) {
        return transactionRepo.findAllByAccount_ClientAndDateBetween(client, from, until)
                .stream()
                .map(TransactionsMapper::responseTransactionsToDto)
                .collect(Collectors.toList());
    }

    public List<TransactionResponseDto> transactionsByAccountNumber(String accountNumber) {
        return transactionRepo.findAllByAccount_AccountNumberOrderByDateDesc(accountNumber)
                .stream()
                .map(TransactionsMapper::responseTransactionsToDto)
                .collect(Collectors.toList());
    }

    public String deleteTransaction(Long transactionId){
        try{
            transactionRepo.deleteById(transactionId);
            return "Transacción con Id: " + transactionId + " eliminada exitosamente";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
