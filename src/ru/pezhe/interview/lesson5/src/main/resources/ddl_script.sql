CREATE TABLE IF NOT EXISTS public.student
(
    id bigint NOT NULL DEFAULT nextval('student_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    mark integer,
    CONSTRAINT student_pkey PRIMARY KEY (id)
);