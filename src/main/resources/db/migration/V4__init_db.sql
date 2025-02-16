DROP SEQUENCE IF EXISTS "orders_id_seq";

-- Create the sequence with increment of 50, starting from 1
CREATE SEQUENCE "orders_id_seq" INCREMENT BY 50 START 1;

-- Drop the table if it exists
DROP TABLE IF EXISTS "orders";

-- Create the table with id set to use the sequence for auto-increment
CREATE TABLE orders(
       id bigint PRIMARY KEY DEFAULT nextval('orders_id_seq'), -- Use the sequence for auto-increment
       user_name VARCHAR(256) NOT NULL,
       order_content VARCHAR(255) NOT NULL,
       status bigint,
       note VARCHAR(500) NOT NULL
);


CREATE TABLE tokens (
    id SERIAL PRIMARY KEY,
    token VARCHAR(500) UNIQUE NOT NULL,
    platform VARCHAR(50)
);