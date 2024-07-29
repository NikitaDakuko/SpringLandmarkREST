CREATE TABLE landmark (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    creationdate DATE NOT NULL,
    description VARCHAR(255) NOT NULL,
    type VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);