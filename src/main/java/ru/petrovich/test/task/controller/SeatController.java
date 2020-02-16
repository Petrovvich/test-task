package ru.petrovich.test.task.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.petrovich.test.task.dto.ResponseDto;
import ru.petrovich.test.task.service.SeatService;

import java.util.Collection;

@Slf4j
@Controller(value = "/seat", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @Get("/{hallId}")
    public ResponseDto getAll(Long hallId) {
        log.debug("SeatController getAll() start handling request with hall id {}", hallId);
        return seatService.getAllByHall(hallId);
    }

    @Get("/vacant/count/{hallId}")
    public ResponseDto getCountVacant(Long hallId) {
        log.debug("SeatController getCountVacant() start handling request with hall id {}", hallId);
        return seatService.getVacantByHall(hallId);
    }

    @Get("/reserve/count/{hallId}")
    public ResponseDto getCountReserve(Long hallId) {
        log.debug("SeatController getCountReserve() start handling request with hall id {}", hallId);
        return seatService.getReservedByHall(hallId);
    }

    @Put("/reserve/{reserve}")
    public ResponseDto reserveSeats(@Body Collection<Long> seatIds, Boolean reserve) {
        log.debug("SeatController reserveSeats() start handling request");
        return seatService.reserveSeats(seatIds, reserve);
    }
}
