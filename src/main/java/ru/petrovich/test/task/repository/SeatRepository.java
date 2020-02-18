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

    @Query(value = QUERY_GET_ALL, nativeQuery = true)
    List<Seat> getAllByHall(Long hallId);
}
