package ru.petrovich.test.task.service;

import lombok.extern.slf4j.Slf4j;
import ru.petrovich.test.task.dto.ResponseDto;
import ru.petrovich.test.task.repository.HallRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import static ru.petrovich.test.task.wrapper.ResponseWrapper.*;

/**
 * Сервис для работы с запросами касающимися сущности {@link ru.petrovich.test.task.model.Hall}
 */
@Slf4j
@Singleton
public class HallService {
    @Inject
    private HallRepository hallRepository;

    public ResponseDto getVacantByHall(Long hallId) {
        log.debug("getVacantByHall(): start handling request with id {}", hallId);
        Long count;
        try {
            count = hallRepository.getCountVacantByHallId(hallId);
        } catch (Exception e) {
            log.error("Exception occurred when get vacant seats by hall id: {}", hallId, e);
            return error();
        }
        if (count == null) {
            log.warn("getVacantByHall(): nothing found for id {}", hallId);
            return notFound();
        }
        return success(count, "Found");
    }

    public ResponseDto getReservedByHall(Long hallId) {
        log.debug("getReservedByHall(): start handling request with id {}", hallId);
        Long count;
        try {
            count = hallRepository.getCountReservedByHallId(hallId);
        } catch (Exception e) {
            log.error("Exception occurred when get reserved seats by hall id: {}", hallId, e);
            return error();
        }
        if (count == null) {
            log.warn("getReservedByHall(): nothing found for id {}", hallId);
            return notFound();
        }
        return success(count, "Found");
    }
}
