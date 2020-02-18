package ru.petrovich.test.task.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Базовый класс представляющий ответ от сервера на запросы
 */
@Valid
public interface ResponseDto extends BaseDto {
    @NotNull
    ResponseStatus getStatus();

    @NotNull
    String getMessage();

    Object getData();
}
