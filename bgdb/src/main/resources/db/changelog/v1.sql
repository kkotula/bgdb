CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA IF NOT EXISTS bgdb;

CREATE TABLE IF NOT EXISTS bgdb.customers
(
    id           UUID PRIMARY KEY NOT NULL,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    street       VARCHAR(50) NOT NULL,
    city         VARCHAR(50) NOT NULL,
    postal_code  VARCHAR(8)  NOT NULL,
    building_no  VARCHAR(5)  NOT NULL,
    apartment_no VARCHAR(50)
);