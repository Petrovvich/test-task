package ru.petrovich.test.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность отображающая представление посадочного места в зале кинотеатра.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seat_id_sequence")
    @SequenceGenerator(name = "seat_id_sequence",
            sequenceName = "seat_id_sequence",
            schema = "cinema"
            , allocationSize = 1)
    private Long id;
    /**
     * Внешний ключ на {@link Hall}
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    private Hall hall;
    /**
     * @see SeatType
     */
    @Enumerated(EnumType.STRING)
    private SeatType type;
    /**
     * Номер ряда посадочного места
     */
    private Long row;
    /**
     * Номер посадочного места в ряде
     */
    private Long number;
    /**
     * Свободно ли посадочное место
     */
    private Boolean vacant;
}
