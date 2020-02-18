package ru.petrovich.test.task.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Collection;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Cinema}
 */
@Data
@NoArgsConstructor
public class CinemaDto implements BaseDto {
    private Long id;
    private Instant created;
    private String name;
    private AddressDto address;
    private RequisitesDto requisites;
    private Collection<HallDto> halls;

    @Builder
    public CinemaDto(Long id, Instant created, String name, AddressDto address, RequisitesDto requisites, Collection<HallDto> halls) {
        this.id = id;
        this.created = created;
        this.name = name;
        this.address = address;
        this.requisites = requisites;
        this.halls = halls;
    }
}
