package ru.petrovich.test.task.service;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import ru.petrovich.test.task.error.SeatNotFoundException;

import javax.inject.Inject;

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
