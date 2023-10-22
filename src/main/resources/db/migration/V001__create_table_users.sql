CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(45),
    "dateOfBirth" TIMESTAMP NOT NULL,
    firstPhone VARCHAR(20),
    secondPhone VARCHAR(20)
);