package ru.petrovich.test.task;

import ru.petrovich.test.task.model.*;

import java.time.Instant;

public class TestUtils {

    public static Address buildEmptyAddress() {
        return Address.builder()
                .id(1L)
                .actualAddress("Actual address")
                .legalAddress("Legal address")
                .postalAddress("Postal address")
                .build();
    }

    public static Cinema buildEmptyCinema() {
        return Cinema.builder()
                .id(1L)
                .created(Instant.now())
                .name("Cinema name")
                .build();
    }

    public static Hall buildEmptyHall() {
        return Hall.builder()
                .id(1L)
                .capacity(100L)
                .name("Hall name")
                .build();
    }

    public static Requisites buildEmptyRequisites() {
        return Requisites.builder()
                .id(1L)
                .categoryCode("Category code")
                .fullName("Full name")
                .inn(12324345L)
                .kpp(1223443L)
                .ocato(12234324L)
                .ogrn(123234L)
                .okved(12324324L)
                .pfrRegNumber(1223432L)
                .build();
    }

    public static Seat buildEmptySeat() {
        return Seat.builder()
                .id(1L)
                .seatNumber(12L)
                .seatRow(1L)
                .vacant(true)
                .seatType(SeatType.SIMPLE)
                .build();
    }
}
