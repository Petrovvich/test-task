package ru.petrovich.test.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Адреса кинотеатра (юридический, фактический, почтовый)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "address_id_sequence")
    @SequenceGenerator(name = "address_id_sequence",
            sequenceName = "address_id_sequence",
            schema = "cinema",
            allocationSize = 1)
    private Long id;

    @OneToOne(mappedBy = "address")
    private Cinema cinema;
    /**
     * Юридический адрес кинотеатра
     */
    private String legalAddress;
    /**
     * Фактический адрес кинотеатра
     */
    private String actualAddress;
    /**
     * Почтовый адрес кинотеатра
     */
    private String postalAddress;
}
