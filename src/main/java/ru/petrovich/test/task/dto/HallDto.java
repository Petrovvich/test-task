package ru.petrovich.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Hall}
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HallDto {
    private Long id;
    private Collection<SeatDto> seats;
    private Long capacity;
    private String name;
}
