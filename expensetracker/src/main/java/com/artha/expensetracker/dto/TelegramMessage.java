package com.artha.expensetracker.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TelegramMessage {
    private TelegramFrom from;
    private TelegramChat chat;
    private String text;
}
