--PostgreSQL--

CREATE TABLE IF NOT EXISTS public.movie
(
    id integer NOT NULL DEFAULT nextval('movie_id_seq'::regclass),
    title text COLLATE pg_catalog."default" NOT NULL,
    duration interval NOT NULL,
    CONSTRAINT movie_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.screening
(
    id integer NOT NULL DEFAULT nextval('screening_id_seq'::regclass),
    showtime timestamp without time zone NOT NULL,
    price money NOT NULL,
    movie_id integer NOT NULL,
    CONSTRAINT screening_pkey PRIMARY KEY (id),
    CONSTRAINT fk_screening_movie FOREIGN KEY (movie_id)
        REFERENCES public.movie (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.ticket
(
    "number" integer NOT NULL DEFAULT nextval('ticket_number_seq'::regclass),
    screening_id integer NOT NULL,
    CONSTRAINT ticket_pkey PRIMARY KEY ("number"),
    CONSTRAINT fk_ticket_screening FOREIGN KEY (screening_id)
        REFERENCES public.screening (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
