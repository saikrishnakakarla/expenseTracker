package com.artha.expensetracker.controller;

import com.artha.expensetracker.dto.TelegramMessage;
import com.artha.expensetracker.dto.TelegramUpdate;
import com.artha.expensetracker.dto.TransactionResponse;
import com.artha.expensetracker.service.TransactionService;
import com.artha.expensetracker.util.TelegramClient;
import com.artha.expensetracker.util.TelegramTextParser;
import com.artha.expensetracker.util.Utils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telegram")
@RequiredArgsConstructor
public class TelegramWebhookController {

    private final TransactionService transactionService;
    private static final Logger log= LoggerFactory.getLogger(TelegramWebhookController.class);
    private final TelegramClient telegramClient;


/*    @PostMapping("/webhook")
    public ResponseEntity<String> onUpdate(@RequestBody TelegramUpdate update) {

        log.info("Inside Controller {}", update);

        // Telegram sends many update types — we only care about messages
    if (message == null || message.getText() == null) {
        return ResponseEntity.ok("ignored");
    }

    String text = message.getText().trim();

    // Ignore commands or messages without numbers
    if (text.startsWith("/") || Utils.containsNoNumbers(text)) {
        return ResponseEntity.ok("ignored");
    }

        TelegramMessage message = update.getMessage();

        TransactionRequest request = TelegramTextParser.parse(message);

        transactionService.addTransaction(request);

        // Telegram only needs 200 OK
        return ResponseEntity.ok("ok");
    }*/
@PostMapping("/webhook")
public ResponseEntity<String> onUpdate(@RequestBody TelegramUpdate update) {

    log.info("Incoming Telegram update: {}", update);

    TelegramMessage message = update.getMessage();

    if (message == null || message.getText() == null) {
        return ResponseEntity.ok("ignored");
    }

    String text = message.getText().trim();

    // Ignore commands or messages without numbers
    if (text.startsWith("/") || Utils.containsNoNumbers(text)) {
        return ResponseEntity.ok("ignored");
    }

    try {
        // Parse Telegram text → TransactionRequest
        TransactionRequest request = TelegramTextParser.parse(message);

        // Save transaction
        TransactionResponse response =
                transactionService.addTransaction(request);

        // Build success message for user
        String successMessage = Utils.buildSuccessMessage(response);

        // Reply back to Telegram user
        telegramClient.sendMessage(
                message.getChat().getId(),
                successMessage
        );

    } catch (Exception ex) {
        log.error("Failed to process telegram message", ex);

        telegramClient.sendMessage(
                message.getChat().getId(),
                "❌ Failed to record transaction. Please try again.\nExample: `30 eggs`"
        );
    }

    // Telegram only needs HTTP 200
    return ResponseEntity.ok("ok");
}


}

