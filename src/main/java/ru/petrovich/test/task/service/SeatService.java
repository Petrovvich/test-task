package ru.petrovich.test.task.service;

import lombok.extern.slf4j.Slf4j;
import ru.petrovich.test.task.dto.ResponseDto;
import ru.petrovich.test.task.error.SeatAlreadyReservedException;
import ru.petrovich.test.task.model.Seat;
import ru.petrovich.test.task.repository.SeatRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static ru.petrovich.test.task.wrapper.ResponseWrapper.*;

/**
 * Сервис для работы с запросами касающимися сущности посадочных мест {@link ru.petrovich.test.task.model.Seat}
 */
@Slf4j
@Singleton
public class SeatService {
    @Inject
    private SeatRepository seatRepository;

    /**
     * Получение количества свободных мест в зале (без детализациипо плану рассадки)
     *
     * @param hallId идентификатор зала
     * @return количество забронированных мест
     */
    public ResponseDto getVacantByHall(Long hallId) {
        log.debug("getVacantByHall(): start handling request with id {}", hallId);
        Long count;
        try {
            count = seatRepository.getCountVacantByHallId(hallId);
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

    /**
     * Получение количества забронированных мест в зале (без детализациипо плану рассадки)
     *
     * @param hallId идентификатор зала
     * @return количество забронированных мест
     */
    public ResponseDto getReservedByHall(Long hallId) {
        log.debug("getReservedByHall(): start handling request with id {}", hallId);
        Long count = seatRepository.getCountReservedByHallId(hallId);
        if (count == null) {
            log.warn("getReservedByHall(): nothing found for id {}", hallId);
            return notFound();
        }
        return success(count, "Found");
    }

    /**
     * Резервирование посадочного места/мест
     *
     * @param seatIds   идентификаторы посадочных мест
     * @param isReserve фдаг отвечающий за бронирование/снятие брони
     * @return результат бронирования
     */
    @Transactional
    public ResponseDto reserveSeats(Collection<Long> seatIds, Boolean isReserve) {
        log.debug("reserveSeats(): start handling request for seat ids {} and reserve flag {}", seatIds, isReserve);
        Map<Long, Boolean> reserveResult = new HashMap<>();
        for (Long id : seatIds) {
            try {
                setVacant(id, isReserve);
                reserveResult.put(id, false);
                log.trace("reserveSeats(): successfully reserved seat with id {}", id);
            } catch (Exception e) {
                log.error("Exception occurred when reserve seat with id {}", id, e);
                reserveResult.put(id, true);
            }
        }
        return success(reserveResult, "Successfully reserved");
    }

    private void setVacant(Long id, Boolean isReserve) throws SeatAlreadyReservedException {
        Seat seat = seatRepository.findById(id).get();
        if (seat.getVacant().equals(isReserve)) {
            throw new SeatAlreadyReservedException(id);
        }
        seat.setVacant(isReserve);
        seatRepository.save(seat);
    }
}
