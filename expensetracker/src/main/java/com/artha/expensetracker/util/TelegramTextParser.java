package com.artha.expensetracker.util;

import com.artha.expensetracker.controller.TransactionRequest;
import com.artha.expensetracker.dto.TelegramMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TelegramTextParser {

    private TelegramTextParser() {
    }

    private static final Logger log =
            LoggerFactory.getLogger(TelegramTextParser.class);

    public static TransactionRequest parse(TelegramMessage message) {
        log.info("Inside parsing: {}", message.getText());
        String text = message.getText();
        String normalizedText = text.toLowerCase().replaceAll("[^a-z0-9.\\s]", " ").replaceAll("\\s+", " ").trim();
        log.info("Normalized text: {}", normalizedText);
        String[] tokens = normalizedText.split("\\s+");
        BigDecimal amount = null;
        StringBuilder rawTextBuilder = new StringBuilder();
        for (String token : tokens) { // detect number only once
            if (amount == null && token.matches("\\d+(\\.\\d+)?")) {
                amount = new BigDecimal(token);
                log.info("Detected amount token: {}", token);
                continue;
            } // keep only meaningful text
            if (token.matches("[a-z]+")) {
                rawTextBuilder.append(token).append(" ");
            }
        }
        if (amount == null) {
            throw new IllegalArgumentException("No amount found in message: " + text);
        }
        String rawText = rawTextBuilder.toString().trim();
        if (rawText.isEmpty()) {
            throw new IllegalArgumentException("No expense description found in message: " + text);
        }
        log.info("Parsed transaction → amount={}, rawText={}", amount, rawText);
        TransactionRequest request = new TransactionRequest();
        request.setTelegramUserId(message.getFrom().getId());
        request.setUserName(message.getFrom().getUserName());
        request.setAmount(amount);
        request.setCurrency("INR");
        request.setRawText(rawText);
        request.setDate(LocalDateTime.now());
        return request;
    }
}

