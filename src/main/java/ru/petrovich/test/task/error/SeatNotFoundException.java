package ru.petrovich.test.task.error;

/**
 * Ошибка выбрасываемая, если посадочное место, над которым будет производиться операция, не найдено в базе данных
 */
public class SeatNotFoundException extends Exception {
    public SeatNotFoundException(Long id) {
        super(String.join(" ", "Nothing found for hall with id", String.valueOf(id)));
    }
}
