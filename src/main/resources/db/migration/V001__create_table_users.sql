CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(45),
    "birth" TIMESTAMP NOT NULL,
    "first_phone" VARCHAR(20),
    "second_phone" VARCHAR(20)
);