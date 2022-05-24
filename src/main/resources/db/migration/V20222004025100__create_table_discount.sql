CREATE TABLE discount(
    discount_code varchar2(8) PRIMARY KEY ,
    discount_name varchar2(16) UNIQUE NOT NULL,
    expire_date DATE ,
    discount_percentage FLOAT (3)
);