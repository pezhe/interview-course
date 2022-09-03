--PostgreSQL--

--Поиск наложений--

SELECT
m1.title AS "фильм 1",
s1.showtime AS "время начала",
m1.duration AS "длительность",
m2.title AS "фильм 2",
s2.showtime AS "время начала",
m2.duration AS "длительность"
FROM screening s1 JOIN movie AS m1 ON m1.id = s1.movie_id,
screening AS s2 JOIN movie AS m2 ON m2.id = s2.movie_id
WHERE s1.showtime < s2.showtime
AND s1.showtime + m1.duration >= s2.showtime
ORDER BY s1.showtime + m1.duration - s2.showtime;

--Поиск перерывов более 30 минут--

CREATE OR REPLACE FUNCTION get_next(curr_start timestamp)
RETURNS timestamp AS 'SELECT MIN(showtime) FROM screening WHERE showtime > curr_start'
LANGUAGE SQL;

CREATE OR REPLACE FUNCTION get_diff(curr_start timestamp, dur interval)
RETURNS interval AS 'SELECT MIN(showtime) - (curr_start + dur) FROM screening WHERE showtime > curr_start'
LANGUAGE SQL;

SELECT
m1.title AS "фильм 1",
s1.showtime AS "время начала",
m1.duration AS "длительность",
get_next(s1.showtime) AS "время начала второго фильма",
get_diff(s1.showtime, m1.duration) AS "длительность перерыва"
FROM screening s1
JOIN movie AS m1 ON m1.id = s1.movie_id
WHERE get_next(s1.showtime) - (s1.showtime + m1.duration) > '30 minutes'
ORDER BY get_diff(s1.showtime, m1.duration);

--Сборы и просмотры по фильмам--

(SELECT
m1.title AS "фильм",
SUM(s1.price) AS "общие сборы",
COUNT(t1.number) AS "всего просмотров",
COUNT(DISTINCT s1.id) AS "кол-во сеансов",
to_char(COUNT(t1.number)::float/COUNT(DISTINCT s1.id)::float, '0.9') AS "ср. кол-во зрителей за сеанс"
FROM screening s1
JOIN movie AS m1 ON m1.id = s1.movie_id
JOIN ticket AS t1 ON t1.screening_id = s1.id
GROUP BY m1.title
ORDER BY SUM(s1.price) DESC)
UNION ALL
(SELECT
'Итого' AS "фильм",
SUM(s1.price) AS "общие сборы",
COUNT(t1.number) AS "всего просмотров",
COUNT(DISTINCT s1.id) AS "кол-во сеансов",
to_char(COUNT(t1.number)::float/COUNT(DISTINCT s1.id)::float, '0.9') AS "ср. кол-во зрителей за сеанс"
FROM screening s1
JOIN movie AS m1 ON m1.id = s1.movie_id
JOIN ticket AS t1 ON t1.screening_id = s1.id);

--Статистика по периодам--

(SELECT 'с 9 до 15' AS "интервал", SUM(s1.price) AS "сборы", COUNT(t1.number) AS "число посетителей"
FROM screening s1 JOIN ticket AS t1 ON t1.screening_id = s1.id
WHERE s1.showtime::time BETWEEN '09:00' AND '14:59')
UNION ALL
(SELECT 'с 15 до 18' AS "интервал", SUM(s1.price) AS "сборы", COUNT(t1.number) AS "число посетителей"
FROM screening s1 JOIN ticket AS t1 ON t1.screening_id = s1.id
WHERE s1.showtime::time BETWEEN '15:00' AND '17:59')
UNION ALL
(SELECT 'с 18 до 21' AS "интервал", SUM(s1.price) AS "сборы", COUNT(t1.number) AS "число посетителей"
FROM screening s1 JOIN ticket AS t1 ON t1.screening_id = s1.id
WHERE s1.showtime::time BETWEEN '18:00' AND '20:59')
UNION ALL
(SELECT 'с 21 до 00' AS "интервал", SUM(s1.price) AS "сборы", COUNT(t1.number) AS "число посетителей"
FROM screening s1 JOIN ticket AS t1 ON t1.screening_id = s1.id
WHERE s1.showtime::time BETWEEN '21:00' AND '24:00' OR s1.showtime::time = '00:00');