package ru.petrovich.test.task.controller;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

import static ru.petrovich.test.task.wrapper.ResponseWrapper.error;

/**
 * Глобальный хэндлер ошибок для api
 */
@Slf4j
@Produces
@Singleton
@Requires(classes = {Throwable.class})
public class RestExceptionHandler implements ExceptionHandler<Throwable, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, Throwable exception) {
        log.error("Exception occurred while process request ", exception);
        return HttpResponse.ok(error(exception.getMessage()));
    }
}
