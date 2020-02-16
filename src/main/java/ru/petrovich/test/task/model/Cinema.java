package ru.petrovich.test.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;

/**
 * Сущность кинотеатра.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cinema_id_sequence")
    @SequenceGenerator(name = "cinema_id_sequence",
            sequenceName = "cinema_id_sequence",
            schema = "cinema",
            allocationSize = 1)
    private Long id;
    /**
     * Дата создания записи в базе данных
     */
    private Instant created;
    /**
     * Название кинотеатра
     */
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    /**
     * @see Requisites
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requisites_id")
    private Requisites requisites;
    /**
     * @see Hall
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cinema_id")
    private Collection<Hall> halls;
}
