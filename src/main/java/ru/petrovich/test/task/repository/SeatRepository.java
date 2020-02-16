package ru.petrovich.test.task.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ru.petrovich.test.task.model.Seat;

/**
 * Репозиторий для работы с сущностью {@link Seat}
 */
@Repository
public interface SeatRepository extends CrudRepository<Seat, Long> {
}
