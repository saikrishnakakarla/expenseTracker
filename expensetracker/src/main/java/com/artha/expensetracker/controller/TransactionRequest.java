package com.artha.expensetracker.controller;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionRequest {
    private Long telegramUserId;
    private String userName;
    private BigDecimal amount;
    private String currency;
    private String rawText;
    private LocalDateTime date;
}

