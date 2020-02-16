package ru.petrovich.test.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Тип посадочного места в зале кинотеатра
 */
@Getter
@AllArgsConstructor
public enum SeatType {
    SIMPLE("Простое место"),
    VIP("Место для VIP-персон"),
    ;

    private String description;
}
