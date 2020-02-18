package ru.petrovich.test.task.error.handlers;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import ru.petrovich.test.task.error.HallNotFoundException;

import javax.inject.Singleton;

import static ru.petrovich.test.task.wrapper.ResponseWrapper.error;

/**
 * Хэндлер ошибок типа {@link HallNotFoundException} для всего api
 */
@Slf4j
@Produces
@Singleton
@Requires(classes = {HallNotFoundException.class})
public class HallNotFoundExceptionHandler implements ExceptionHandler<HallNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, HallNotFoundException exception) {
        log.error("Exception occurred while process request ", exception);
        return HttpResponse.notFound(error(exception.getMessage()));
    }
}
