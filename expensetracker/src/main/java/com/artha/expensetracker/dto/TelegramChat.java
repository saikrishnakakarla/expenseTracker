package com.artha.expensetracker.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class TelegramChat {
    private Long id;
    private String type; // "private", "group", etc.
}
