package com.artha.expensetracker.service;

import com.artha.expensetracker.controller.TransactionRequest;
import com.artha.expensetracker.dto.TransactionResponse;
import com.artha.expensetracker.entity.CategoryEntity;
import com.artha.expensetracker.entity.CategoryKeywordEntity;
import com.artha.expensetracker.entity.TransactionEntity;
import com.artha.expensetracker.entity.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.artha.expensetracker.repository.CategoryKeywordRepository;
import com.artha.expensetracker.repository.TransactionRepository;
import com.artha.expensetracker.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final UserRepository userRepo;
    private final TransactionRepository transactionRepo;
    private final CategoryKeywordRepository keywordRepo;
    private final UserServiceImpl UserServiceImpl;


/*    @Override
    public TransactionResponse addTransaction(
            Long telegramUserId,
            String userName,
            BigDecimal amount,
            String currency,
            String rawText,
            LocalDateTime date) {

       *//* UserEntity user = userRepo.findByTelegramUserId(telegramUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));*//*

        UserEntity user = UserServiceImpl.getOrCreateUser(telegramUserId, userName);

        CategoryEntity category = detectCategory(rawText);
        System.out.println("Category details : " + category);
        System.out.println("Cat ID : " + category.getId());

        TransactionEntity tx = new TransactionEntity();
        tx.setId(UUID.randomUUID());
        tx.setUser(user);
        tx.setAmount(amount);
        tx.setCurrency(currency);
        tx.setTransactionType(category.getId() < 2000 ? "EXPENSE" : "INCOME");
        tx.setTransactionDate(date);
        tx.setRawText(rawText);
        tx.setCategory(category);

        return transactionRepo.save(tx);
        TransactionEntity saved = saveTransactionLogic(request);
    }*/

    @Override
    public TransactionResponse addTransaction(TransactionRequest request) {

       /* UserEntity user = userRepo.findByTelegramUserId(telegramUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));*/

        UserEntity user = UserServiceImpl.getOrCreateUser(request.getTelegramUserId(), request.getUserName());

        CategoryEntity category = detectCategory(request.getRawText());
        System.out.println("Category details : " + category);
        System.out.println("Cat ID : " + category.getId());

        TransactionEntity tx = new TransactionEntity();
        tx.setId(UUID.randomUUID());
        tx.setUser(user);
        tx.setAmount(request.getAmount());
        tx.setCurrency(request.getCurrency());
        tx.setTransactionType(category.getId() < 2000 ? "EXPENSE" : "INCOME");
        tx.setTransactionDate(request.getDate());
        tx.setRawText(request.getRawText());
        tx.setCategory(category);
/*        return transactionRepo.save(tx);
        TransactionEntity saved = saveTransactionLogic(request);*/
        TransactionEntity saved = transactionRepo.save(tx);
        return toResponse(saved);
    }

    @Override
    public List<TransactionEntity> getUserTransactions(Long telegramUserId) {
        UserEntity user = userRepo.findByTelegramUserId(telegramUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return transactionRepo.findByUserUserIdOrderByTransactionDateDesc(user.getUserId());
    }


    private CategoryEntity detectCategory(String rawText) {
        CategoryEntity miscellaneous = keywordRepo.findMiscellaneousCategory()
                .orElseThrow(() -> new IllegalStateException(
                        "Miscellaneous category missing in DB"
                ));
        if (rawText == null || rawText.isBlank()) {
            return miscellaneous;
        }
        return Arrays.stream(rawText.toLowerCase().split("\\s+")).map(keywordRepo::findByKeywordIgnoreCase).filter(Optional::isPresent).map(opt -> opt.get().getCategory()).findFirst().orElse(null);
    }


    private TransactionResponse toResponse(TransactionEntity tx) {

        return new TransactionResponse(
                tx.getId(),
                tx.getAmount(),
                tx.getCurrency(),
                tx.getTransactionDate(),
                tx.getTransactionType(),
                tx.getCategory() != null ? tx.getCategory().getId() : null,
                tx.getCategory() != null ? tx.getCategory().getName() : null,
                tx.getRawText()
        );
    }

}
