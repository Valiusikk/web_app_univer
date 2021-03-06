CREATE TABLE booking(
    booking_id VARCHAR2(36) PRIMARY KEY,
    booking_status VARCHAR2(16),
    amount FLOAT(6),
    pickup_location VARCHAR2(16),
    drop_location VARCHAR2(16),
    registration_number VARCHAR2(8) UNIQUE,
    client_id VARCHAR2(36),
    discount_code VARCHAR2(8),
    start_date_time TIMESTAMP,
    end_date_time TIMESTAMP,
    insurance_code VARCHAR2(16),
);