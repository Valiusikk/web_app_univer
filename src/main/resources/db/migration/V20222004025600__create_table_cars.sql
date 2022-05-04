CREATE TABLE cars(
    registration_number VARCHAR2(8) PRIMARY KEY,
    model_name VARCHAR2(16),
    model_year INTEGER(4),
    milleage INTEGER(6),
    car_category VARCHAR2(16),
    location_id VARCHAR2(36),
    FOREIGN KEY(location_id) REFERENCES location(location_id),
    FOREIGN KEY (car_category) REFERENCES car_category(car_category)
);