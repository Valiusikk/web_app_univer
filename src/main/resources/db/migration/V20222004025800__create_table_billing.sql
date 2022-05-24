CREATE TABLE billing(
    bill_id VARCHAR2(36) PRIMARY KEY ,
    bill_date DATE ,
    bill_status VARCHAR2(16),
    discount_amount FLOAT (3),
    total_amount FLOAT(6),
    tax_amount FLOAT(6),
    booking_id VARCHAR2(36),
    FOREIGN KEY(booking_id) REFERENCES booking(booking_id)
);