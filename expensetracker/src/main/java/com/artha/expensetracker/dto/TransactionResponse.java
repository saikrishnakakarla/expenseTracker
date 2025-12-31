package com.artha.expensetracker.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public record TransactionResponse(
        UUID id,
        BigDecimal amount,
        String currency,
        LocalDateTime transactionDate,
        String transactionType,
        Integer categoryId,
        String categoryName,
        String rawText
) {}
