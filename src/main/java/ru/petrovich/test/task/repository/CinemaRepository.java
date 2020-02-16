package ru.petrovich.test.task.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ru.petrovich.test.task.model.Cinema;


/**
 * Репозиторий для работы с сущностью {@link Cinema}
 */
@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long> {
}
