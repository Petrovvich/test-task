package ru.petrovich.test.task.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.petrovich.test.task.dto.SeatDto;
import ru.petrovich.test.task.model.Seat;

/**
 * Класс маппера для преобразования {@link Seat} в {@link SeatDto} и обратно
 */
@Mapper
public interface SeatMapper {

    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    SeatDto map(Seat source);
}
