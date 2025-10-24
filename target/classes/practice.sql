USE taxi_db;

-- 10 LEFT JOINS
SELECT d.driver_id, d.name, MAX(dl.license_number) AS max_license
FROM Drivers d
LEFT JOIN DriversLicenses dl ON d.driver_id = dl.driver_id
GROUP BY d.driver_id, d.name;

SELECT c.car_id, c.license_plate, COUNT(d.driver_id) AS total_drivers
FROM Cars c
LEFT JOIN Drivers_has_Cars dc ON c.car_id = dc.car_id
LEFT JOIN Drivers d ON dc.driver_id = d.driver_id
GROUP BY c.car_id, c.license_plate;

SELECT b.booking_id, p.name AS passenger, COUNT(r.ride_id) AS total_rides
FROM Bookings b
LEFT JOIN Passengers p ON b.passenger_id = p.passenger_id
LEFT JOIN Rides r ON b.booking_id = r.booking_id
GROUP BY b.booking_id, p.name;

SELECT pm.method_name, SUM(py.amount) AS total_amount
FROM PaymentMethods pm
LEFT JOIN Payments py ON pm.method_id = py.method_id
GROUP BY pm.method_name;

SELECT r.ride_id, AVG(f.total_amount) AS avg_fare
FROM Rides r
LEFT JOIN Fares f ON r.fare_id = f.fare_id
GROUP BY r.ride_id;

SELECT p.passenger_id, p.name, MIN(rv.rating) AS min_rating
FROM Passengers p
LEFT JOIN Reviews rv ON p.passenger_id = rv.passenger_id
GROUP BY p.passenger_id, p.name;

SELECT d.name, COUNT(i.incident_id) AS total_incidents
FROM Drivers d
LEFT JOIN Incidents i ON d.driver_id = i.driver_id
GROUP BY d.name;

SELECT b.booking_id, COUNT(pr.code) AS total_promotions
FROM Bookings b
LEFT JOIN Promotions pr ON b.promotion_id = pr.promotion_id
GROUP BY b.booking_id;

SELECT r.ride_id, SUM(py.amount) AS total_paid
FROM Rides r
LEFT JOIN Payments py ON r.payment_id = py.payment_id
LEFT JOIN PaymentMethods pm ON py.method_id = pm.method_id
GROUP BY r.ride_id;

SELECT r.ride_id, COUNT(l2.location_id) AS destinations_count
FROM Rides r
LEFT JOIN Locations l1 ON r.origin_id = l1.location_id
LEFT JOIN Locations l2 ON r.destination_id = l2.location_id
GROUP BY r.ride_id;

-- 10 RIGHT JOINS
SELECT d.driver_id, d.name, dl.license_number
FROM Drivers d
RIGHT JOIN DriversLicenses dl ON d.driver_id = dl.driver_id;

SELECT c.car_id, c.license_plate, d.name
FROM Cars c
RIGHT JOIN Drivers_has_Cars dc ON c.car_id = dc.car_id
RIGHT JOIN Drivers d ON dc.driver_id = d.driver_id;

SELECT b.booking_id, p.name AS passenger, r.ride_id
FROM Rides r
RIGHT JOIN Bookings b ON r.booking_id = b.booking_id
RIGHT JOIN Passengers p ON b.passenger_id = p.passenger_id;

SELECT py.amount, pm.method_name
FROM Payments py
RIGHT JOIN PaymentMethods pm ON py.method_id = pm.method_id;

SELECT r.ride_id, f.total_amount
FROM Fares f
RIGHT JOIN Rides r ON r.fare_id = f.fare_id;

SELECT rv.rating, p.name
FROM Reviews rv
RIGHT JOIN Passengers p ON rv.passenger_id = p.passenger_id;

SELECT i.description, d.name
FROM Incidents i
RIGHT JOIN Drivers d ON i.driver_id = d.driver_id;

SELECT b.booking_id, pr.code
FROM Promotions pr
RIGHT JOIN Bookings b ON b.promotion_id = pr.promotion_id;

SELECT py.amount, pm.method_name, r.ride_id
FROM Payments py
RIGHT JOIN PaymentMethods pm ON py.method_id = pm.method_id
RIGHT JOIN Rides r ON py.payment_id = r.payment_id;

SELECT r.ride_id, l1.comment AS origin, l2.comment AS destination
FROM Locations l1
RIGHT JOIN Rides r ON r.origin_id = l1.location_id
RIGHT JOIN Locations l2 ON r.destination_id = l2.location_id;

-- 10 INNER JOINS
SELECT d.name, dl.license_number
FROM Drivers d
INNER JOIN DriversLicenses dl ON d.driver_id = dl.driver_id;

SELECT c.license_plate, COUNT(d.driver_id) AS driver_count
FROM Cars c
INNER JOIN Drivers_has_Cars dc ON c.car_id = dc.car_id
INNER JOIN Drivers d ON dc.driver_id = d.driver_id
GROUP BY c.license_plate;

SELECT b.booking_id, p.name, COUNT(r.ride_id) AS rides_per_booking
FROM Bookings b
INNER JOIN Passengers p ON b.passenger_id = p.passenger_id
INNER JOIN Rides r ON b.booking_id = r.booking_id
GROUP BY b.booking_id, p.name;

SELECT AVG(py.amount) AS avg_amount, pm.method_name
FROM Payments py
INNER JOIN PaymentMethods pm ON py.method_id = pm.method_id
GROUP BY pm.method_name;

SELECT r.ride_id, MAX(f.total_amount) AS max_fare
FROM Rides r
INNER JOIN Fares f ON r.fare_id = f.fare_id
GROUP BY r.ride_id;

SELECT p.name, AVG(rv.rating) AS avg_rating
FROM Passengers p
INNER JOIN Reviews rv ON p.passenger_id = rv.passenger_id
GROUP BY p.name;

SELECT d.name, COUNT(i.incident_id) AS incident_count
FROM Drivers d
INNER JOIN Incidents i ON d.driver_id = i.driver_id
GROUP BY d.name;

SELECT b.booking_id, COUNT(pr.code) AS promo_count
FROM Bookings b
INNER JOIN Promotions pr ON b.promotion_id = pr.promotion_id
GROUP BY b.booking_id;

SELECT r.ride_id, SUM(py.amount) AS ride_total
FROM Rides r
INNER JOIN Payments py ON r.payment_id = py.payment_id
INNER JOIN PaymentMethods pm ON py.method_id = pm.method_id
GROUP BY r.ride_id;

SELECT r.ride_id, COUNT(l2.location_id) AS stop_count
FROM Rides r
INNER JOIN Locations l1 ON r.origin_id = l1.location_id
INNER JOIN Locations l2 ON r.destination_id = l2.location_id
GROUP BY r.ride_id;

-- 1 BIG QUERY
SELECT r.ride_id, psg.name AS passenger, d.name AS driver, c.license_plate,
       pr.code AS promotion, pm.method_name, SUM(py.amount) AS total_amount, MAX(f.total_amount) AS max_fare,
       AVG(rv.rating) AS avg_rating, COUNT(i.incident_id) AS incidents_count,
       l1.comment AS origin, l2.comment AS destination, tc.name AS company
FROM Rides r
INNER JOIN Bookings b ON r.booking_id = b.booking_id
INNER JOIN Passengers psg ON b.passenger_id = psg.passenger_id
INNER JOIN Drivers d ON r.driver_id = d.driver_id
INNER JOIN Cars c ON r.car_id = c.car_id
INNER JOIN TaxiCompany tc ON d.company_id = tc.company_id
LEFT JOIN Promotions pr ON b.promotion_id = pr.promotion_id
LEFT JOIN Payments py ON r.payment_id = py.payment_id
LEFT JOIN PaymentMethods pm ON py.method_id = pm.method_id
LEFT JOIN Fares f ON r.fare_id = f.fare_id
LEFT JOIN Reviews rv ON psg.passenger_id = rv.passenger_id AND d.driver_id = rv.driver_id
LEFT JOIN Incidents i ON r.ride_id = i.ride_id
LEFT JOIN Locations l1 ON r.origin_id = l1.location_id
LEFT JOIN Locations l2 ON r.destination_id = l2.location_id
GROUP BY r.ride_id, psg.name, d.name, c.license_plate, pr.code, pm.method_name, l1.comment, l2.comment, tc.name;

-- 3 GROUP BY 
SELECT d.driver_id, d.name, COUNT(r.ride_id) AS total_rides, AVG(f.total_amount) AS avg_fare
FROM Drivers d
LEFT JOIN Rides r ON d.driver_id = r.driver_id
LEFT JOIN Fares f ON r.fare_id = f.fare_id
GROUP BY d.driver_id, d.name;

SELECT p.passenger_id, p.name, COUNT(b.booking_id) AS total_bookings, SUM(py.amount) AS total_spent
FROM Passengers p
LEFT JOIN Bookings b ON p.passenger_id = b.passenger_id
LEFT JOIN Rides r ON b.booking_id = r.booking_id
LEFT JOIN Payments py ON r.payment_id = py.payment_id
GROUP BY p.passenger_id, p.name;

SELECT c.company_id, c.name, COUNT(dr.driver_id) AS total_drivers, MIN(dl.license_number) AS min_license
FROM TaxiCompany c
LEFT JOIN Drivers dr ON c.company_id = dr.company_id
LEFT JOIN DriversLicenses dl ON dr.driver_id = dl.driver_id
GROUP BY c.company_id, c.name;

-- 3 HAVING 
SELECT d.driver_id, d.name, COUNT(r.ride_id) AS total_rides
FROM Drivers d
LEFT JOIN Rides r ON d.driver_id = r.driver_id
GROUP BY d.driver_id, d.name
HAVING COUNT(r.ride_id) > 1;

SELECT p.passenger_id, p.name, COUNT(b.booking_id) AS total_bookings
FROM Passengers p
LEFT JOIN Bookings b ON p.passenger_id = b.passenger_id
GROUP BY p.passenger_id, p.name
HAVING COUNT(b.booking_id) >= 2;

SELECT d.driver_id, d.name, AVG(rv.rating) AS avg_rating
FROM Drivers d
LEFT JOIN Reviews rv ON d.driver_id = rv.driver_id
GROUP BY d.driver_id, d.name
HAVING AVG(rv.rating) < 4;
