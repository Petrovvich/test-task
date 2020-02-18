--liquibase formatted sql
--preconditions onFail:MARK_RAN
--changeset alexromantrue@gmail.com:1
insert into cinema
values (nextval('cinema_id_sequence'), now(), 'Победа'),
       (nextval('cinema_id_sequence'), now(), 'Эдем киномир');

--liquibase formatted sql
--preconditions onFail:MARK_RAN
--changeset alexromantrue@gmail.com:2
insert into hall
values (nextval('hall_id_sequence'), 1, 'Первый зал', 50),
       (nextval('hall_id_sequence'), 1, 'Большой зал', 150),
       (nextval('hall_id_sequence'), 1, 'Второй зал', 100),
       (nextval('hall_id_sequence'), 1, 'Третий зал', 100),
       (nextval('hall_id_sequence'), 1, 'Четвертый зал', 100),
       (nextval('hall_id_sequence'), 1, 'Пятый зал', 100),
       (nextval('hall_id_sequence'), 1, 'Клубный зал', 50),
       (nextval('hall_id_sequence'), 1, 'Малый зал', 30),
       (nextval('hall_id_sequence'), 2, 'Первый зал', 50),
       (nextval('hall_id_sequence'), 2, 'Второй зал', 50),
       (nextval('hall_id_sequence'), 2, 'Третий', 50),
       (nextval('hall_id_sequence'), 2, 'Четвертый зал', 50),
       (nextval('hall_id_sequence'), 2, 'Пятый зал', 50);

--liquibase formatted sql
--preconditions onFail:MARK_RAN
--changeset alexromantrue@gmail.com:3
insert into seat
values (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 1, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 2, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 3, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 4, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 5, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 6, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 7, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 8, true),
       (nextval('seat_id_sequence'), 1, 'SIMPLE', 1, 9, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 1, 10, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 1, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 2, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 3, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 4, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 5, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 6, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 7, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 8, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 9, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 2, 10, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 1, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 2, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 3, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 4, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 5, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 6, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 7, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 8, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 9, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 3, 10, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 1, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 2, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 3, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 4, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 5, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 6, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 7, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 8, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 9, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 4, 10, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 1, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 2, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 3, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 4, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 5, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 6, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 7, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 8, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 9, true),
(nextval('seat_id_sequence'), 1,'SIMPLE', 5, 10, true);