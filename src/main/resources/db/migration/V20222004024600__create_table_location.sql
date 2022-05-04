CREATE TABLE location(
    location_id VARCHAR2(36) PRIMARY KEY,
    location_name VARCHAR2(32) UNIQUE NOT NULL,
    street VARCHAR2(16),
    city VARCHAR2(16),
    state_name VARCHAR2(16),
    zipcode VARCHAR2(16) UNIQUE NOT NULL
);