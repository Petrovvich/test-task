package ru.petrovich.test.task.mappers;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.petrovich.test.task.dto.HallDto;
import ru.petrovich.test.task.model.Hall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.petrovich.test.task.TestUtils.buildEmptyHall;

@MicronautTest(packages = {"ru.petrovich.test.task.mappers"})
public class HallMapperTest {
    private static Hall source;

    @BeforeAll
    static void setUp() {
        source = buildEmptyHall();
    }

    @Test
    public void simpleMapperTest() {
        HallDto target = HallMapper.INSTANCE.map(source);
        assertNotNull(target);
        assertEquals(source.getCapacity(), target.getCapacity());
        assertEquals(source.getId(), target.getId());
        assertEquals(source.getName(), target.getName());
    }
}
