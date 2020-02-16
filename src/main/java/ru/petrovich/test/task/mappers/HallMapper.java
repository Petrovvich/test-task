package ru.petrovich.test.task.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.petrovich.test.task.dto.HallDto;
import ru.petrovich.test.task.model.Hall;

/**
 * Класс маппера для преобразования {@link Hall} в {@link HallDto} и обратно
 */
@Mapper
public interface HallMapper {

    HallMapper INSTANCE = Mappers.getMapper(HallMapper.class);

    HallDto map(Hall source);
}
