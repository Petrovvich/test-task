package ru.petrovich.test.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Dto объект для сущности {@link ru.petrovich.test.task.model.Address}
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {
    private Long id;
    private String legalAddress;
    private String actualAddress;
    private String postalAddress;
}
