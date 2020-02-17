package ru.petrovich.test.task.error;

/**
 * Ошибка выбрасываемая, если зал кинотеатра, над которым будет производиться операция, не найдено в базе данных
 */
public class HallNotFoundException extends Exception {
    public HallNotFoundException(Long id) {
        super(String.join(" ", "Hall with id", String.valueOf(id), "not found in database"));
    }
}
