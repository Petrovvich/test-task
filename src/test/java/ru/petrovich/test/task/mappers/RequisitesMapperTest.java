package ru.petrovich.test.task.mappers;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.petrovich.test.task.dto.RequisitesDto;
import ru.petrovich.test.task.model.Requisites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.petrovich.test.task.TestUtils.buildEmptyRequisites;

@MicronautTest(packages = {"ru.petrovich.test.task.mappers"})
public class RequisitesMapperTest {
    private static Requisites source;

    @BeforeAll
    static void setUp() {
        source = buildEmptyRequisites();
    }

    @Test
    public void simpleMapperTest() {
        RequisitesDto target = RequisitesMapper.INSTANCE.map(source);
        assertNotNull(target);
        assertEquals(source.getId(), target.getId());
        assertEquals(source.getCategoryCode(), target.getCategoryCode());
        assertEquals(source.getFullName(), target.getFullName());
        assertEquals(source.getInn(), target.getInn());
        assertEquals(source.getKpp(), target.getKpp());
        assertEquals(source.getOcato(), target.getOcato());
        assertEquals(source.getOgrn(), target.getOgrn());
        assertEquals(source.getOkved(), target.getOkved());
        assertEquals(source.getPfrRegNumber(), target.getPfrRegNumber());
    }
}
