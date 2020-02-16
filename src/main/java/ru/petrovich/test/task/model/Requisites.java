package ru.petrovich.test.task.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Финансовые данные компании - расчетный счет, ИНН, ОГРН, КПП, корреспондентский счет и т.д
 */
@Data
@Entity
public class Requisites {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "requisites_id_sequence")
    @SequenceGenerator(name = "requisites_id_sequence",
            sequenceName = "requisites_id_sequence",
            schema = "cinema"
            , allocationSize = 1)
    private Long id;

    @OneToOne(mappedBy = "requisites")
    private Cinema cinema;
    /**
     * ИНН юридического лица владеющего кинотеатром
     */
    private Long inn;
    /**
     * КПП юридического лица владеющего кинотеатром
     */
    private Long kpp;
    /**
     * Полное наименование юридического лица владеющего кинотеатром
     */
    private String fullName;
    /**
     * Регистрационный номер в ПФР (как работодателя) юридического лица владеющего кинотеатром
     */
    private Long pfrRegNumber;
    /**
     * ОГРН юридического лица владеющего кинотеатром
     */
    private Long ogrn;
    /**
     * Код категории юридического лица владеющего кинотеатром
     */
    private String categoryCode;
    /**
     * ОКВЭД юридического лица владеющего кинотеатром
     */
    private Long okved;
    /**
     * ОКАТО юридического лица владеющего кинотеатром
     */
    private Long ocato;
}
