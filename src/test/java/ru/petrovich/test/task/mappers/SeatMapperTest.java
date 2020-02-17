package ru.petrovich.test.task.mappers;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.petrovich.test.task.dto.SeatDto;
import ru.petrovich.test.task.model.Seat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.petrovich.test.task.TestUtils.buildEmptySeat;

@MicronautTest(propertySources = "classpath:application-test.yml")
public class SeatMapperTest {
    private static Seat source;

    @BeforeAll
    static void setUp() {
        source = buildEmptySeat();
    }

    @Test
    public void simpleMapperTest() {
        SeatDto target = SeatMapper.INSTANCE.map(source);
        assertNotNull(target);
        assertEquals(source.getId(), target.getId());
        assertEquals(source.getSeatNumber(), target.getNumber());
        assertEquals(source.getSeatRow(), target.getRow());
        assertEquals(source.getSeatType(), target.getType());
        assertEquals(source.getVacant(), target.getVacant());
    }
}
