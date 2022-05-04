package ru.petrovich.test.task.service;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import ru.petrovich.test.task.error.SeatNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
public class SeatServiceTest {

    @Inject
    SeatService seatService;

    @Test
    public void testGetAllByHall_notFound() {
        assertThrows(SeatNotFoundException.class, () -> seatService.getAllByHall(1L));
    }
}
