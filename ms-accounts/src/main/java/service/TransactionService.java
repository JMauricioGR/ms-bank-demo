package service;

import domain.Account;
import domain.Transactions;
import dtos.response.TransactionResponseDto;
import enums.TransactionsType;
import mappers.TransactionsMapper;
import org.springframework.stereotype.Service;
import repository.AccountsRepository;
import repository.TransactionsRepository;

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

    public Transactions createTransaction(String accountNumber, BigDecimal amount){
        Account account = accountRepo.findByAccountNumber(accountNumber);

        BigDecimal newAmount = account.getBalance().add(amount);
        if (newAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException();
        }
        Transactions transaction = new Transactions();
        transaction.setAccount(account);
        transaction.setDate(LocalDateTime.now());
        transaction.setAmount(amount);
        transaction.setAmount(newAmount);
        transaction.setTransactionType(amount.signum() >= 0 ? TransactionsType.CREDITO : TransactionsType.DEBITO);

        account.setBalance(newAmount);
        accountRepo.save(account);
        return transactionRepo.save(transaction);
    }

    public List<TransactionResponseDto> transactionsByAccountNumberAndDateRange(String accountNumber, LocalDateTime from, LocalDateTime until) {
        return transactionRepo.findAllByAccount_AccountNumberAndDateBetween(accountNumber, from, until)
                .stream()
                .map(TransactionsMapper::responseTransactionsToDto)
                .collect(Collectors.toList());
    }

    public List<TransactionResponseDto> transactionsByAccountNumber(String accountNumber) {
        return transactionRepo.findAllByAccount_AccountNumberOrderByDatesDesc(accountNumber)
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
