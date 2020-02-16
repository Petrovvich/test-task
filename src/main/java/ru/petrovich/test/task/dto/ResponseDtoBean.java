package ru.petrovich.test.task.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Базовое DTO для работы с api модуля
 */
@Data
@NoArgsConstructor
public class ResponseDtoBean implements ResponseDto {
    @NotNull
    private ResponseStatus status;
    @NotNull
    private String message;
    private Object data;

    @Builder
    public ResponseDtoBean(@NotNull ResponseStatus status, @NotNull String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
