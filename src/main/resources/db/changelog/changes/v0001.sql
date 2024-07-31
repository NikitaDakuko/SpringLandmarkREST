--changeset nikita:1
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS landmark;
DROP TABLE IF EXISTS service;
DROP TABLE IF EXISTS landmark_service;

CREATE TABLE IF NOT EXISTS location (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    population BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    metro BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS landmark (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    creation_date DATE NOT NULL,
    description VARCHAR(255) NOT NULL,
    location_id BIGINT NOT NULL,
    type VARCHAR(25) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT location_landmark
        FOREIGN KEY(location_id)
            REFERENCES location(id)
);

CREATE TABLE IF NOT EXISTS service (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS landmark_service (
    landmark_id BIGINT REFERENCES landmark(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    service_id BIGINT REFERENCES service(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);