-- ==========================================
-- Kailua CarRental database
-- ==========================================

-- Hvis databasen allerede findes, slet den
DROP DATABASE IF EXISTS kailua_rental;

-- Opret ny database
CREATE DATABASE kailua_rental;
USE kailua_rental;

-- ==========================================
-- 1. Tabel: CarCategory
-- ==========================================
CREATE TABLE CarCategory (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    gear_type ENUM('manual','automatic'),
    min_ccm INT,
    min_hp INT,
    seats_min INT,
    has_aircon BOOLEAN DEFAULT TRUE,
    has_cruise BOOLEAN DEFAULT FALSE,
    leather_seats BOOLEAN DEFAULT FALSE
);

-- Indsæt 3 kategorier
INSERT INTO CarCategory (name, description, gear_type, min_ccm, min_hp, seats_min, has_aircon, has_cruise, leather_seats)
VALUES
('Luxury','>3000 ccm, automatisk, A/C, cruise, lædersæder','automatic',3000,NULL,5,TRUE,TRUE,TRUE),
('Family','Manuel, A/C, 7+ sæder, nogle med cruise','manual',NULL,NULL,7,TRUE,FALSE,FALSE),
('Sport','Manuel, >200 hk','manual',NULL,200,2,FALSE,FALSE,FALSE);

-- ==========================================
-- 2. Tabel: Car
-- ==========================================
CREATE TABLE Car (
    reg_number VARCHAR(20) PRIMARY KEY,   -- nummerplade
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    fuel_type VARCHAR(20),
    first_registration DATE,
    odometer_km INT DEFAULT 0,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES CarCategory(category_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Indsæt 3 biler (en i hver kategori)
INSERT INTO Car (reg_number, brand, model, fuel_type, first_registration, odometer_km, category_id)
VALUES
('LUX123','Mercedes','S-Class','Petrol','2019-03-01',45000,1),
('FAM456','Volkswagen','Sharan','Diesel','2017-06-15',120000,2),
('SPT789','Porsche','911','Petrol','2021-05-10',8000,3);

-- ==========================================
-- 3. Tabel: Customer
-- ==========================================
CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(150),
    zip VARCHAR(10),
    city VARCHAR(50),
    mobile_phone VARCHAR(30),
    phone VARCHAR(30),
    email VARCHAR(100),
    driver_license_number VARCHAR(50) UNIQUE NOT NULL,
    driver_since DATE
);

-- Indsæt 3 kunder
INSERT INTO Customer (name,address,zip,city,mobile_phone,phone,email,driver_license_number,driver_since)
VALUES
('Morten Hansen','Lindenvej 12','2100','København','+45 12345678','+45 33445566','morten@example.com','DL123456','2010-05-20'),
('Anna Larsen','Parkvej 4','8000','Aarhus','+45 98765432',NULL,'anna.l@example.com','DL223344','2015-11-12'),
('Jonas Petersen','Hovedgaden 1','5000','Odense','+45 77889900',NULL,'jonas.p@example.com','DL998877','2008-02-02');

-- ==========================================
-- 4. Tabel: RentalContract
-- ==========================================
CREATE TABLE RentalContract (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    car_reg_number VARCHAR(20) NOT NULL,
    from_datetime DATETIME NOT NULL,
    to_datetime DATETIME NOT NULL,
    max_km INT,
    start_odometer_km INT NOT NULL,
    return_odometer_km INT,
    status ENUM('active','returned','cancelled') DEFAULT 'active',
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (car_reg_number) REFERENCES Car(reg_number)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

-- Indsæt 3 kontrakter
INSERT INTO RentalContract (customer_id, car_reg_number, from_datetime, to_datetime, max_km, start_odometer_km, return_odometer_km, status)
VALUES
(1,'LUX123','2025-09-01 10:00:00','2025-09-05 12:00:00',1000,45000,46000,'returned'),
(2,'FAM456','2025-09-10 09:00:00','2025-09-15 17:00:00',500,120000,NULL,'active'),
(3,'SPT789','2025-09-12 14:00:00','2025-09-13 20:00:00',200,8000,8200,'returned');

-- ==========================================
-- Ekstra indexer (valgfrit, men godt til performance)
-- ==========================================
CREATE INDEX idx_rental_customer ON RentalContract(customer_id);
CREATE INDEX idx_rental_car ON RentalContract(car_reg_number);
