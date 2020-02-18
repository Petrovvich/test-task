package ru.petrovich.test.task.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ru.petrovich.test.task.model.Requisites;

/**
 * Репозиторий для работы с сущностью {@link Requisites}
 */
@Repository
public interface RequisitesRepository extends CrudRepository<Requisites, Long> {
}
