package ru.petrovich.test.task.error.handlers;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import ru.petrovich.test.task.error.SeatNotFoundException;

import javax.inject.Singleton;

import static ru.petrovich.test.task.wrapper.ResponseWrapper.error;

/**
 * Хэндлер ошибок типа {@link SeatNotFoundException} для всего api
 */
@Slf4j
@Produces
@Singleton
@Requires(classes = {SeatNotFoundException.class})
public class SeatNotFoundExceptionHandler implements ExceptionHandler<SeatNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, SeatNotFoundException exception) {
        log.error("Exception occurred while process request ", exception);
        return HttpResponse.notFound(error(exception.getMessage()));
    }
}
