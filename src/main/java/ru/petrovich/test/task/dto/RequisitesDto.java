package ru.petrovich.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Requisites}
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisitesDto {
    private Long id;
    private Long inn;
    private Long kpp;
    private String fullName;
    private Long pfrRegNumber;
    private Long ogrn;
    private String categoryCode;
    private Long okved;
    private Long ocato;
}
