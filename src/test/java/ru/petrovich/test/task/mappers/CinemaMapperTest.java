package ru.petrovich.test.task.mappers;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.petrovich.test.task.dto.CinemaDto;
import ru.petrovich.test.task.model.Cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.petrovich.test.task.TestUtils.buildEmptyCinema;

@MicronautTest(propertySources = "classpath:application-test.yml")
public class CinemaMapperTest {
    private static Cinema source;

    @BeforeAll
    static void setUp() {
        source = buildEmptyCinema();
    }

    @Test
    public void simpleMapperTest() {
        CinemaDto target = CinemaMapper.INSTANCE.map(source);
        assertNotNull(target);
        assertEquals(source.getCreated(), target.getCreated());
        assertEquals(source.getId(), target.getId());
        assertEquals(source.getName(), target.getName());
    }
}