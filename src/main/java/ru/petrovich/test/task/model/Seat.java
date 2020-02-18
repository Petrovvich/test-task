package ru.petrovich.test.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * Сущность отображающая представление посадочного места в зале кинотеатра.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"hall"})
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id")
    private Hall hall;
    /**
     * @see SeatType
     */
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    /**
     * Номер ряда посадочного места
     */
    private Long seatRow;
    /**
     * Номер посадочного места в ряде
     */
    private Long seatNumber;
    /**
     * Свободно ли посадочное место
     */
    private Boolean vacant;
}
