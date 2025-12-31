package com.artha.expensetracker.repository;

import com.artha.expensetracker.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository
        extends JpaRepository<TransactionEntity, UUID> {

    List<TransactionEntity> findByUserUserIdOrderByTransactionDateDesc(UUID userId);
}

