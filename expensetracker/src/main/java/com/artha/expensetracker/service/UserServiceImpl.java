package com.artha.expensetracker.service;

import com.artha.expensetracker.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.artha.expensetracker.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getOrCreateUser(Long telegramUserId, String userName) {

        return userRepository.findByTelegramUserId(telegramUserId)
                .map(user -> {
                    // update username if it changed
                    if (!Objects.equals(user.getUserName(), userName)) {
                        user.setUserName(userName);
                        user.setUpdatedAt(LocalDateTime.now());
                        return userRepository.save(user);
                    }
                    return user;
                })
                .orElseGet(() -> createUser(telegramUserId, userName));
    }

    private UserEntity createUser(Long telegramUserId, String userName) {

        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID());
        user.setTelegramUserId(telegramUserId);
        user.setUserName(userName);
        user.setDeleted(false);

        return userRepository.save(user);
    }
}

