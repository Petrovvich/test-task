package ru.petrovich.test.task.wrapper;

import ru.petrovich.test.task.dto.ResponseDto;
import ru.petrovich.test.task.dto.ResponseDtoBean;
import ru.petrovich.test.task.dto.ResponseStatus;

/**
 * Класс предоставляющий интерфейсдля создания ответов от api сервера
 */
public class ResponseWrapper {
    private static final String DEFAULT_SUCCESS_MESSAGE = "Request successfully done";
    private static final String DEFAULT_ERROR_MESSAGE = "Request failed";
    private static final String DEFAULT_NOT_FOUND_MESSAGE = "Nothing found for request";

    public static ResponseDto success(Object data, String message) {
        return ofStatusAndBodyAndMessage(ResponseStatus.SUCCESS, data, message);
    }

    public static ResponseDto success(String message) {
        return ofStatusAndMessage(ResponseStatus.SUCCESS, message);
    }

    public static ResponseDto success() {
        return ofStatusAndMessage(ResponseStatus.SUCCESS, DEFAULT_SUCCESS_MESSAGE);
    }

    public static ResponseDto error(Object data, String message) {
        return ofStatusAndBodyAndMessage(ResponseStatus.ERROR, data, message);
    }

    public static ResponseDto error(String message) {
        return ofStatusAndMessage(ResponseStatus.ERROR, message);
    }

    public static ResponseDto error() {
        return ofStatusAndMessage(ResponseStatus.ERROR, DEFAULT_ERROR_MESSAGE);
    }

    public static ResponseDto notFound(Object data, String message) {
        return ofStatusAndBodyAndMessage(ResponseStatus.NOT_FOUND, data, message);
    }

    public static ResponseDto notFound(String message) {
        return ofStatusAndMessage(ResponseStatus.NOT_FOUND, message);
    }

    public static ResponseDto notFound() {
        return ofStatusAndMessage(ResponseStatus.NOT_FOUND, DEFAULT_NOT_FOUND_MESSAGE);
    }

    private static ResponseDto ofStatusAndBodyAndMessage(ResponseStatus status, Object data, String message) {
        return ResponseDtoBean.builder()
                .message(message)
                .status(status)
                .data(data)
                .build();
    }

    private static ResponseDto ofStatusAndMessage(ResponseStatus status, String message) {
        return ResponseDtoBean.builder()
                .message(message)
                .status(status)
                .build();
    }
}
