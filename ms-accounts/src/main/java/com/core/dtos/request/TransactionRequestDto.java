package com.core.dtos.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestDto implements Serializable {
    private String accountNumber;
    private BigDecimal amount;
    private LocalDateTime dateFrom;
    private LocalDateTime dateUntil;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(LocalDateTime dateUntil) {
        this.dateUntil = dateUntil;
    }

}