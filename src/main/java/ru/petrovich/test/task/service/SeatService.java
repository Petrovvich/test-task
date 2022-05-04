package ru.petrovich.test.task.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.petrovich.test.task.dto.ResponseDto;
import ru.petrovich.test.task.error.SeatAlreadyReservedException;
import ru.petrovich.test.task.error.SeatNotFoundException;
import ru.petrovich.test.task.mappers.SeatMapper;
import ru.petrovich.test.task.model.Seat;
import ru.petrovich.test.task.repository.SeatRepository;

import jakarta.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.petrovich.test.task.wrapper.ResponseWrapper.success;

/**
 * Сервис для работы с запросами касающимися сущности посадочных мест {@link ru.petrovich.test.task.model.Seat}
 */
@Slf4j
@Singleton
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    /**
     * Получение списка всех мест в зале
     *
     * @param hallId идентификатор зала
     * @return количество забронированных мест
     */
    public ResponseDto getAllByHall(Long hallId) throws SeatNotFoundException {
        log.debug("getAllByHall(): start handling request with id {}", hallId);
        List<Seat> found = seatRepository.getAllByHall(hallId);
        if (found == null || found.size() == 0) {
            log.warn("getAllByHall(): nothing found for id {}", hallId);
            throw new SeatNotFoundException(hallId);
        }
        return success(found.stream().map(SeatMapper.INSTANCE::map).collect(Collectors.toList()), "Found");
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
                setVacant(id, !isReserve);
                reserveResult.put(id, true);
                log.trace("reserveSeats(): successfully reserved seat with id {}", id);
            } catch (Exception e) {
                log.error("Exception occurred when reserve seat with id {}", id, e);
                reserveResult.put(id, false);
            }
        }
        return success(reserveResult, "Reserved");
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
