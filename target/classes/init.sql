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


-- Inserts

INSERT INTO TaxiCompany (name, address, phone) VALUES
('City Taxi', '123 Main St', '555-1234'),
('Metro Cabs', '456 Elm St', '555-5678');

INSERT INTO Cars (license_plate, model, brand, year, company_id) VALUES
('ABC123', 'Corolla', 'Toyota', 2018, 1),
('XYZ789', 'Civic', 'Honda', 2020, 1),
('JKL456', 'Focus', 'Ford', 2019, 2);

INSERT INTO Drivers (name, phone, hire_date, company_id) VALUES
('John Doe', '555-1111', '2020-01-10', 1),
('Jane Smith', '555-2222', '2021-03-15', 1),
('Carlos Perez', '555-3333', '2019-07-01', 2);

INSERT INTO DriversLicenses (license_number, expiration_date, driver_id) VALUES
('D123456', '2026-05-10', 1),
('D654321', '2025-11-20', 2),
('D789123', '2027-02-01', 3);

INSERT INTO Drivers_has_Cars (driver_id, car_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 2);

INSERT INTO Passengers (name, phone) VALUES
('Alice Johnson', '555-4444'),
('Bob Martinez', '555-5555'),
('Clara Lee', '555-6666');

INSERT INTO Reviews (rating, comment, passenger_id, driver_id) VALUES
(5, 'Great ride!', 1, 1),
(4, 'Good service.', 2, 1),
(3, 'Average experience.', 3, 2);

INSERT INTO Promotions (code, description, discount_percentage) VALUES
('PROMO10', '10% off first ride', 10.00),
('SUMMER20', '20% off summer special', 20.00);

INSERT INTO Locations (latitude, longitude, comment) VALUES
(40.712776, -74.005974, 'Downtown'),
(40.730610, -73.935242, 'Uptown'),
(40.758896, -73.985130, 'Midtown'),
(40.706192, -74.009160, 'Financial District');

INSERT INTO PaymentMethods (method_name) VALUES
('Credit Card'),
('Cash'),
('Mobile Payment');

INSERT INTO Payments (amount, payment_date, method_id) VALUES
(25.50, '2023-09-01 10:15:00', 1),
(15.75, '2023-09-02 14:30:00', 2),
(40.00, '2023-09-03 20:45:00', 3);

INSERT INTO Bookings (booking_date, passenger_id, promotion_id) VALUES
('2023-09-01 09:50:00', 1, 1),
('2023-09-02 14:00:00', 2, NULL),
('2023-09-03 20:15:00', 3, 2);

INSERT INTO Fares (base_fare, cost_per_km, cost_per_minute, total_amount) VALUES
(3.00, 1.50, 0.50, 25.50),
(3.00, 1.50, 0.50, 15.75),
(3.00, 1.50, 0.50, 40.00);

INSERT INTO Rides (distance, duration, waiting_time, passengers_count, origin_id, destination_id, booking_id, driver_id, car_id, payment_id, fare_id) VALUES
(10, 20, 5, 1, 1, 2, 1, 1, 1, 1, 1),
(6, 15, 3, 2, 2, 3, 2, 2, 2, 2, 2),
(15, 30, 10, 1, 3, 4, 3, 3, 3, 3, 3);

INSERT INTO Incidents (description, incident_date, driver_id, ride_id) VALUES
('Flat tire during ride', '2023-09-01 10:30:00', 1, 1),
('Passenger complaint', '2023-09-02 14:45:00', 2, 2),
('Minor accident reported', '2023-09-03 21:00:00', 3, 3);
