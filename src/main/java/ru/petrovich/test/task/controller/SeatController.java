package ru.petrovich.test.task.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.petrovich.test.task.dto.ResponseDto;
import ru.petrovich.test.task.error.SeatNotFoundException;
import ru.petrovich.test.task.service.SeatService;

import java.util.Collection;

/**
 * Контроллер для приема и передачи на обработку запросов, связанных с сущностью {@link ru.petrovich.test.task.model.Seat}
 */
@Slf4j
@Controller(value = "/seats", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @Get("/{hallId}")
    public HttpResponse<ResponseDto> getAll(Long hallId) throws SeatNotFoundException {
        log.debug("SeatController getAll() start handling request with hall id {}", hallId);
        return HttpResponse.ok(seatService.getAllByHall(hallId));
    }

    @Get("/vacant/count/{hallId}")
    public HttpResponse<ResponseDto> getCountVacant(Long hallId) throws SeatNotFoundException {
        log.debug("SeatController getCountVacant() start handling request with hall id {}", hallId);
        return HttpResponse.ok(seatService.getVacantByHall(hallId));
    }

    @Get("/reserve/count/{hallId}")
    public HttpResponse<ResponseDto> getCountReserve(Long hallId) throws SeatNotFoundException {
        log.debug("SeatController getCountReserve() start handling request with hall id {}", hallId);
        return HttpResponse.ok(seatService.getReservedByHall(hallId));
    }

    @Put("/reserve/{reserve}")
    public HttpResponse<ResponseDto> reserveSeats(@Body Collection<Long> seatIds, Boolean reserve) {
        log.debug("SeatController reserveSeats() start handling request");
        return HttpResponse.ok(seatService.reserveSeats(seatIds, reserve));
    }
}
