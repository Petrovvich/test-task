package ru.petrovich.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Collection;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Cinema}
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto {
    private Long id;
    private Instant created;
    private String name;
    private AddressDto address;
    private RequisitesDto requisites;
    private Collection<HallDto> halls;
}
