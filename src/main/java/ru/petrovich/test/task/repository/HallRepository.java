package ru.petrovich.test.task.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ru.petrovich.test.task.model.Hall;

/**
 * Репозиторий для работы с сущностью {@link Hall}
 */
@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {
}
