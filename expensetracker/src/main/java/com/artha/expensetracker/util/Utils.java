package com.artha.expensetracker.util;

import com.artha.expensetracker.dto.TransactionResponse;
import com.artha.expensetracker.entity.TransactionEntity;

public class Utils {

    public static boolean containsNoNumbers(String text) {
        if (text == null || text.isBlank()) {
            return true;
        }
        return !text.matches(".*\\d+.*");
    }

    public static String buildSuccessMessage(TransactionResponse response) {

        String typeEmoji =
                "INCOME".equalsIgnoreCase(response.transactionType())
                        ? "💰"
                        : "✅";

        return String.format(
                "%s %s recorded successfully\n• Category: %s\n• Amount: %s %s",
                typeEmoji,
                response.transactionType(),
                response.categoryName(),
                response.currency(),
                response.amount()
        );
    }



}
