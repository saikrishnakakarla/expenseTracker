package com.artha.expensetracker.service;

import com.artha.expensetracker.entity.UserEntity;

public interface UserService {

    UserEntity getOrCreateUser(
            Long telegramUserId,
            String userName
    );
}

