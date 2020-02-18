package ru.petrovich.test.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * Адреса кинотеатра (юридический, фактический, почтовый)
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cinema"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "address_id_sequence")
    @SequenceGenerator(name = "address_id_sequence",
            sequenceName = "address_id_sequence",
            schema = "cinema",
            allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
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
