CREATE TABLE bgdb.address
(
    id           UUID PRIMARY KEY NOT NULL,
    customer_id  UUID NOT NULL,
    street       VARCHAR(50) NOT NULL,
    city         VARCHAR(50) NOT NULL,
    postal_code  VARCHAR(8) NOT NULL,
    building_no  VARCHAR(5) NOT NULL,
    apartment_no VARCHAR(50),
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id)
            REFERENCES bgdb.customers (id)
);
