package com.artha.expensetracker.controller;

import com.artha.expensetracker.dto.TelegramMessage;
import com.artha.expensetracker.dto.TelegramUpdate;
import com.artha.expensetracker.dto.TransactionResponse;
import com.artha.expensetracker.entity.TransactionEntity;
import com.artha.expensetracker.util.TelegramTextParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.artha.expensetracker.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    /*public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }*/

    @PostMapping()
    public ResponseEntity<String> addTransaction(
            @RequestBody TransactionRequest request) {

        /*TransactionEntity tx = transactionService.addTransaction(
                request.getTelegramUserId(),
                request.getUserName(),
                request.getAmount(),
                request.getCurrency(),
                request.getRawText(),
                request.getDate()
        );

        return ResponseEntity.ok(tx);*/

        TransactionResponse response =
                transactionService.addTransaction(request);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> onUpdate(@RequestBody TelegramUpdate update) {

        // Telegram sends many update types — we only care about messages
        if (update.getMessage() == null || update.getMessage().getText() == null) {
            return ResponseEntity.ok("ignored");
        }

        TelegramMessage message = update.getMessage();

        TransactionRequest request = TelegramTextParser.parse(message);

        transactionService.addTransaction(request);

        // Telegram only needs 200 OK
        return ResponseEntity.ok("ok");
    }


    @GetMapping("/{telegramUserId}")
    public ResponseEntity<List<TransactionEntity>> getTransactions(
            @PathVariable Long telegramUserId) {

        return ResponseEntity.ok(
                transactionService.getUserTransactions(telegramUserId)
        );
    }
}

