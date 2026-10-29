-- Cities

INSERT INTO city (id, name, state) VALUES
(1, 'Toronto', 'Ontario'),
(2, 'Dubai', 'Dubai'),
(3, 'Frankfurt', 'Hesse');

-- Airports

INSERT INTO airport (id, code, name, city_id) VALUES
(1, 'YYZ', 'Toronto Pearson International Airport', 1),
(2, 'DXB', 'Dubai International Airport', 2),
(3, 'FRA', 'Frankfurt Airport', 3);

-- Passengers

INSERT INTO passenger (id, first_name, last_name, phone_number, city_id) VALUES
(1, 'Ahmed', 'Ali', '7091234567', 1),
(2, 'Sara', 'Khan', '7095551234', 1),
(3, 'Omar', 'Hassan', '7097778888', 1);

-- Aircraft

INSERT INTO aircraft (id, airline_name, number_of_passengers, type) VALUES
(1, 'Air Canada', 180, 'Boeing 737'),
(2, 'Emirates', 220, 'Airbus A320');

-- Flights

INSERT INTO flight (id, aircraft_id, arrival_airport_id, departure_airport_id) VALUES
(1, 1, 1, 2),
(2, 2, 1, 2),
(3, 1, 2, 1),
(4, 2, 3, 2),
(5, 1, 1, 3);

-- Flight Passengers

INSERT INTO flight_passengers (flight_id, passenger_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(5, 1),
(5, 2);
