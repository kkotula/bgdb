CREATE TABLE bgdb.address
(
    id           UUID DEFAULT gen_random_uuid (),
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

-- Migration part
INSERT INTO bgdb.address (customer_id, street, city, postal_code, building_no, apartment_no)
SELECT id, street, city, postal_code, building_no, apartment_no FROM bgdb.customers;