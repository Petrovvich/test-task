package ru.petrovich.test.task;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Cinema application",
                version = "0.1",
                description = "Application for reserve seats in cinema",
                contact = @Contact(url = "https://github.com/Petrovvich", name = "Alexander Romanyuk", email = "alexromantrue@gmail.com")
        )
)
public class CinemaApplication {

    public static void main(String[] args) {
        Micronaut.run(CinemaApplication.class);
    }
}