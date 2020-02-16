package ru.petrovich.test.task.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ru.petrovich.test.task.model.Seat;

import java.util.List;

/**
 * Репозиторий для работы с сущностью {@link Seat}
 */
@Repository
public interface SeatRepository extends CrudRepository<Seat, Long> {
    String QUERY_GET_ALL = "select * from seat where hall_id = :hallId";
    String QUERY_COUNT_VACANT = "select * from seat where hall_id = :hallId and vacant";
    String QUERY_COUNT_RESERVED = "select * from seat where hall_id = :hallId and not vacant";
    String QUERY_RESERVE = "update seat set vacant = false where id = :seatId";

    @Query(value = QUERY_GET_ALL, nativeQuery = true)
    List<Seat> getAllByHall(Long hallId);

    /**
     * Получение списка свободных мест по идентификатору зала
     *
     * @param hallId идентификатор зала
     * @return свободные места в зале
     */
    @Query(value = QUERY_COUNT_VACANT, nativeQuery = true)
    List<Seat> getCountVacantByHallId(Long hallId);

    /**
     * Получение списка занятых мест по идентификатору зала
     *
     * @param hallId идентификатор зала
     * @return занятых места в зале
     */
    @Query(value = QUERY_COUNT_RESERVED, nativeQuery = true)
    List<Seat> getCountReservedByHallId(Long hallId);

    @Query(value = QUERY_RESERVE, nativeQuery = true)
    void reserve(Long seatId);
}
