package ru.petrovich.test.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Сущность отображающая представление зала в кинотеатре
 */
@Data
@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "hall_id_sequence")
    @SequenceGenerator(name = "hall_id_sequence",
            sequenceName = "hall_id_sequence",
            schema = "cinema",
            allocationSize = 1)
    private Long id;
    /**
     * Внешний ключ на {@link Cinema}
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    /**
     * @see Seat
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "hall_id")
    private Collection<Seat> seats;
    /**
     * Вместимость зала
     */
    private Long capacity;
    /**
     * Название зала в кинотеатре
     */
    private String name;

}
