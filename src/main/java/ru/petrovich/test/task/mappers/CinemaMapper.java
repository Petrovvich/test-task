package ru.petrovich.test.task.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.petrovich.test.task.dto.CinemaDto;
import ru.petrovich.test.task.model.Cinema;

/**
 * Класс маппера для преобразования {@link Cinema} в {@link CinemaDto} и обратно
 */
@Mapper
public interface CinemaMapper {

    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);

    CinemaDto map(Cinema source);
}
