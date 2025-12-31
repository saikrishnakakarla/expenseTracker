package com.artha.expensetracker.service;

import com.artha.expensetracker.controller.TransactionRequest;
import com.artha.expensetracker.dto.TransactionResponse;
import com.artha.expensetracker.entity.TransactionEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    TransactionResponse addTransaction(TransactionRequest request);

    List<TransactionEntity> getUserTransactions(Long telegramUserId);
}

