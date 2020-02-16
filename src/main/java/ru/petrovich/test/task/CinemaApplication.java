package ru.petrovich.test.task;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "ru-petrovich-test-task",
            version = "0.0"
    )
)
public class CinemaApplication {

    public static void main(String[] args) {
        Micronaut.run(CinemaApplication.class);
    }
}