create table client(
    client_id VARCHAR2(36) PRIMARY KEY,
    first_name VARCHAR2(32),
    last_name VARCHAR2(32),
    phone_number VARCHAR2(16) UNIQUE NOT NULL,
    email VARCHAR2(16) UNIQUE NOT NULL,
    confidence_factor INTEGER(4),
    password VARCHAR2(64) UNIQUE NOT NULL,
    location_id VARCHAR2(36),
    role_id VARCHAR2(36),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (location_id) REFERENCES location(location_id)
);