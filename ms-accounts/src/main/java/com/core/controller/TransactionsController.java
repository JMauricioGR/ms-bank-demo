package com.core.controller;

import com.core.dtos.request.TransactionRequestDto;
import com.core.dtos.response.TransactionResponseDto;
import org.springframework.web.bind.annotation.*;
import com.core.service.TransactionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movimientos/")
public class TransactionsController {

    private final TransactionService service;

    public TransactionsController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("reportes")
    public List<TransactionResponseDto> getTransactionsByClientAndDateRange(@RequestParam("cliente") String accountNumber, @RequestParam("fechaInicio")LocalDateTime from, @RequestParam("fechaFin") LocalDateTime until){
        return service.transactionsByClientAndDateRange(accountNumber, from, until);
    }

    @GetMapping("transactions")
    public List<TransactionResponseDto> getTransactionsByAccount(@RequestParam("numeroCuenta") String accountNumber){
        return service.transactionsByAccountNumber(accountNumber);
    }

    @DeleteMapping("delete/{id}")
    public String deleteTransaction(@PathVariable("id") Long id){
        return service.deleteTransaction(id);
    }

    @PostMapping("create")
    public TransactionResponseDto createTransaction(@RequestBody TransactionRequestDto requestDto){
        return service.createTransaction(requestDto.getAccountNumber(), requestDto.getAmount());
    }

}
