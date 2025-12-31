package com.artha.expensetracker.repository;

import com.artha.expensetracker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByTelegramUserId(Long telegramUserId);
}

