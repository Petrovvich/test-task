package ru.petrovich.test.task.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Hall}
 */
@Data
@NoArgsConstructor
public class HallDto implements BaseDto {
    private Long id;
    private Collection<SeatDto> seats;
    private Long capacity;
    private String name;

    @Builder
    public HallDto(Long id, Collection<SeatDto> seats, Long capacity, String name) {
        this.id = id;
        this.seats = seats;
        this.capacity = capacity;
        this.name = name;
    }
}
