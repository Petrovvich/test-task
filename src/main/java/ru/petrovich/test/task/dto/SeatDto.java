package ru.petrovich.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.petrovich.test.task.model.SeatType;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Seat}
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatDto {
    private Long id;
    private SeatType type;
    private Long row;
    private Long number;
    private Boolean vacant;
}
