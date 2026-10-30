-- Cities

INSERT INTO city (id, name, state, population) VALUES
(1, 'Toronto', 'Ontario', 2930000),
(2, 'Dubai', 'Dubai', 3560000),
(3, 'Frankfurt', 'Hesse', 764000);

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
(2, 'Emirates', 220, 'Airbus A320'),
(3, 'Lufthansa', 210, 'Airbus A321');

-- Flights

INSERT INTO flight
(id, aircraft_id, arrival_airport_id, departure_airport_id)
VALUES

(1, 2, 3, 2),   -- DXB -> FRA (Emirates)

(2, 3, 1, 3),   -- FRA -> YYZ (Lufthansa)

(3, 1, 2, 1),   -- YYZ -> DXB (Air Canada)

(4, 2, 1, 2);   -- DXB -> YYZ (Emirates)

-- Flight Passengers

INSERT INTO flight_passengers
(flight_id, passenger_id)
VALUES

(1, 1),   -- Ahmed

(2, 1),   -- Ahmed
(2, 2),   -- Sara

(3, 3),   -- Omar

(4, 3);   -- Omar
