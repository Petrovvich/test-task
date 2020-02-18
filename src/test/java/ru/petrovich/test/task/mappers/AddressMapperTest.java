package ru.petrovich.test.task.mappers;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.petrovich.test.task.dto.AddressDto;
import ru.petrovich.test.task.model.Address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.petrovich.test.task.TestUtils.buildEmptyAddress;

@MicronautTest(propertySources = "classpath:application-test.yml")
public class AddressMapperTest {
    private static Address source;

    @BeforeAll
    static void setUp() {
        source = buildEmptyAddress();
    }

    @Test
    public void simpleMapperTest() {
        AddressDto target = AddressMapper.INSTANCE.map(source);
        assertNotNull(target);
        assertEquals(source.getActualAddress(), target.getActualAddress());
        assertEquals(source.getLegalAddress(), target.getLegalAddress());
        assertEquals(source.getPostalAddress(), target.getPostalAddress());
        assertEquals(source.getId(), target.getId());
    }
}
