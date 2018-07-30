CREATE TABLE driver
(
  id     BIGINT NOT NULL,
  name   CHARACTER VARYING(255),
  rating INTEGER,
  CONSTRAINT driver_pkey PRIMARY KEY (id)
);
ALTER TABLE driver
  OWNER TO internship;

CREATE TABLE car
(
  id        BIGINT NOT NULL,
  car_id    CHARACTER VARYING(255),
  model     CHARACTER VARYING(255),
  status    CHARACTER VARYING(255),
  driver_id BIGINT,
  CONSTRAINT car_pkey PRIMARY KEY (id),
  CONSTRAINT driver_fk FOREIGN KEY (driver_id)
  REFERENCES driver (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_car_id UNIQUE (car_id)
);

ALTER TABLE car
  OWNER TO internship;

CREATE SEQUENCE car_seq;
ALTER TABLE car_seq
  OWNER TO internship;

CREATE SEQUENCE driver_seq;
ALTER TABLE driver_seq
  OWNER TO internship;