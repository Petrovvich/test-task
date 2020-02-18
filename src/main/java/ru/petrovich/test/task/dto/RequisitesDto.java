package ru.petrovich.test.task.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Requisites}
 */
@Data
@NoArgsConstructor
public class RequisitesDto implements BaseDto {
    private Long id;
    private Long inn;
    private Long kpp;
    private String fullName;
    private Long pfrRegNumber;
    private Long ogrn;
    private String categoryCode;
    private Long okved;
    private Long ocato;

    @Builder
    public RequisitesDto(Long id, Long inn, Long kpp, String fullName, Long pfrRegNumber, Long ogrn,
                         String categoryCode, Long okved, Long ocato) {
        this.id = id;
        this.inn = inn;
        this.kpp = kpp;
        this.fullName = fullName;
        this.pfrRegNumber = pfrRegNumber;
        this.ogrn = ogrn;
        this.categoryCode = categoryCode;
        this.okved = okved;
        this.ocato = ocato;
    }
}
