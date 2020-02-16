package ru.petrovich.test.task.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ru.petrovich.test.task.model.Address;

/**
 * Репозиторий для работы с сущностью {@link Address}
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
