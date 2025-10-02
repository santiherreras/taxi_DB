CREATE DATABASE taxi_db;
USE taxi_db;

CREATE TABLE TaxiCompany (
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200),
    phone VARCHAR(20)
);

CREATE TABLE Cars (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    license_plate VARCHAR(20) NOT NULL UNIQUE,
    model VARCHAR(50),
    brand VARCHAR(50),
    year YEAR,
    company_id INT,
    FOREIGN KEY (company_id) REFERENCES TaxiCompany(company_id)
);

CREATE TABLE Drivers (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    hire_date DATE,
    company_id INT,
    FOREIGN KEY (company_id) REFERENCES TaxiCompany(company_id)
);

CREATE TABLE DriversLicenses (
    license_id INT AUTO_INCREMENT PRIMARY KEY,
    license_number VARCHAR(50) UNIQUE NOT NULL,
    expiration_date DATE NOT NULL,
    driver_id INT UNIQUE,
    FOREIGN KEY (driver_id) REFERENCES Drivers(driver_id)
);

CREATE TABLE Drivers_has_Cars (
    driver_id INT,
    car_id INT,
    PRIMARY KEY (driver_id, car_id),
    FOREIGN KEY (driver_id) REFERENCES Drivers(driver_id),
    FOREIGN KEY (car_id) REFERENCES Cars(car_id)
);

CREATE TABLE Passengers (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);

CREATE TABLE Reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    rating INT NOT NULL,
    comment VARCHAR(255),
    passenger_id INT,
    driver_id INT,
    FOREIGN KEY (passenger_id) REFERENCES Passengers(passenger_id),
    FOREIGN KEY (driver_id) REFERENCES Drivers(driver_id)
);



CREATE TABLE Promotions (
    promotion_id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(200),
    discount_percentage DECIMAL(5,2) NOT NULL
);

CREATE TABLE Locations (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    latitude DECIMAL(10,8) NOT NULL,
    longitude DECIMAL(11,8) NOT NULL,
    comment VARCHAR(100)
);

CREATE TABLE PaymentMethods (
    method_id INT AUTO_INCREMENT PRIMARY KEY,
    method_name VARCHAR(50) NOT NULL
);


CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10,2) NOT NULL,
    payment_date DATETIME NOT NULL,
    method_id INT,
    FOREIGN KEY (method_id) REFERENCES PaymentMethods(method_id)
);


CREATE TABLE Bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_date DATETIME NOT NULL,
    passenger_id INT,
    promotion_id INT,
    FOREIGN KEY (passenger_id) REFERENCES Passengers(passenger_id),
    FOREIGN KEY (promotion_id) REFERENCES Promotions(promotion_id)
);


CREATE TABLE Fares (
    fare_id INT AUTO_INCREMENT PRIMARY KEY,
    base_fare DECIMAL(10,2) NOT NULL,
    cost_per_km DECIMAL(10,2),
    cost_per_minute DECIMAL(10,2),
    total_amount DECIMAL(10,2) NOT NULL
);

CREATE TABLE Rides (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,
    distance INT,
    duration INT,
    waiting_time INT,
    passengers_count INT,
    origin_id INT,
    destination_id INT,
    booking_id INT,
    driver_id INT,
    car_id INT,
    payment_id INT,
    fare_id INT,
    FOREIGN KEY (origin_id) REFERENCES Locations(location_id),
    FOREIGN KEY (destination_id) REFERENCES Locations(location_id),
    FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id),
    FOREIGN KEY (driver_id) REFERENCES Drivers(driver_id),
    FOREIGN KEY (car_id) REFERENCES Cars(car_id),
    FOREIGN KEY (payment_id) REFERENCES Payments(payment_id),
    FOREIGN KEY (fare_id) REFERENCES Fares(fare_id)
);

CREATE TABLE Incidents (
    incident_id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    incident_date DATETIME NOT NULL,
    driver_id INT,
    ride_id INT,
    FOREIGN KEY (driver_id) REFERENCES Drivers(driver_id),
    FOREIGN KEY (ride_id) REFERENCES Rides(ride_id)
);