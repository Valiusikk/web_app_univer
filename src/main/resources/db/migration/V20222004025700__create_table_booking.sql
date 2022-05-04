CREATE TABLE booking(
    booking_id VARCHAR2(36) PRIMARY KEY,
    booking_status VARCHAR2(16) NOT NULL,
    amount FLOAT(6),
    pickup_location VARCHAR2(16),
    drop_location VARCHAR2(16),
    registration_number VARCHAR2(8) UNIQUE NOT NULL,
    client_id VARCHAR2(36) NOT NULL ,
    discount_code VARCHAR2(8),
    start_date_time TIMESTAMP,
    end_date_time TIMESTAMP,
    insurance_code VARCHAR2(16) NOT NULL,
    FOREIGN KEY (discount_code) REFERENCES discount(discount_code),
    FOREIGN KEY (registration_number) REFERENCES cars(registration_number),
    FOREIGN KEY (insurance_code) REFERENCES insurance(insurance_code),
    FOREIGN KEY (client_id) REFERENCES client(client_id)
);