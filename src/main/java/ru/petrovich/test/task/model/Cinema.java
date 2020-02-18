package ru.petrovich.test.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
@ToString(exclude = {"halls"})
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
    /**
     * @see Address
     */
    @JsonIgnore
    @OneToOne(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;
    /**
     * @see Requisites
     */
    @JsonIgnore
    @OneToOne(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Requisites requisites;
    /**
     * @see Hall
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cinema_id")
    private Collection<Hall> halls;
}
