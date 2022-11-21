ALTER TABLE bgdb.customers
    ALTER street DROP NOT NULL,
    ALTER city DROP NOT NULL,
    ALTER postal_code DROP NOT NULL,
    ALTER building_no DROP NOT NULL;
