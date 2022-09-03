--PostgreSQL--

INSERT INTO public.movie(title, duration) VALUES
('Pulp Fiction', '2:34:00'),
('Casablanca', '01:32:00'),
('Lawrence of Arabia', '3:42:00'),
('Maverick', '2:09:00'),
('Big Lebowsky', '1:57:00');

INSERT INTO public.screening(showtime, price, movie_id) VALUES
('2022-09-01 12:00:00', 10.50, (SELECT id FROM movie WHERE title = 'Pulp Fiction')),
('2022-09-01 14:00:00', 8.00, (SELECT id FROM movie WHERE title = 'Casablanca')),
('2022-09-01 16:00:00', 12.50, (SELECT id FROM movie WHERE title = 'Lawrence of Arabia')),
('2022-09-01 18:00:00', 11.00, (SELECT id FROM movie WHERE title = 'Maverick')),
('2022-09-01 22:00:00', 9.25, (SELECT id FROM movie WHERE title = 'Big Lebowsky')),
('2022-09-02 00:00:00', 5.50, (SELECT id FROM movie WHERE title = 'Pulp Fiction'));

INSERT INTO public.ticket(screening_id) VALUES
((SELECT id FROM screening WHERE showtime = '2022-09-01 12:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 14:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 14:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 14:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 16:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 18:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 18:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 18:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 22:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-01 22:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-02 00:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-02 00:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-02 00:00:00')),
((SELECT id FROM screening WHERE showtime = '2022-09-02 00:00:00'));



