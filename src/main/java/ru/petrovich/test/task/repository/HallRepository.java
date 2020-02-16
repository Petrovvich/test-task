package ru.petrovich.test.task.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ru.petrovich.test.task.model.Hall;

/**
 * Репозиторий для работы с сущностью {@link Hall}
 */
@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {
    String QUERY_COUNT_VACANT = "select count(id) from seat where hall_id = :hallId and vacant";
    String QUERY_COUNT_RESERVED = "select count(id) from seat where hall_id = :hallId and not vacant";

    /**
     * Получение списка свободных мест (без подробностей о каждом месте) по идентификатору зала
     *
     * @param hallId идентификатор зала
     * @return количество свободных мест в зале
     */
    @Query(value = QUERY_COUNT_VACANT, nativeQuery = true)
    Long getCountVacantByHallId(Long hallId);

    /**
     * Получение списка занятых мест (без подробностей о каждом месте) по идентификатору зала
     *
     * @param hallId идентификатор зала
     * @return количество свободных мест в зале
     */
    @Query(value = QUERY_COUNT_RESERVED, nativeQuery = true)
    Long getCountReservedByHallId(Long hallId);
}
