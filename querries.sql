-- create tables and insert data 

CREATE TABLE device (
    device_id INT PRIMARY KEY AUTO_INCREMENT,
    device_name VARCHAR(255) NOT NULL,
    device_amount DECIMAL(10, 2) NOT NULL
);

INSERT INTO device (device_name, device_amount) VALUES
('Apple iPhone15', 23000),
('Samsung galaxy s23', 27000),
('Hauwei nova', 30000),
('Xiaomi redmi note', 15000),
('Apple iPhone 13 Pro', 7000);

CREATE TABLE repayment_period (
    period_id INT PRIMARY KEY AUTO_INCREMENT,
    months INT NOT NULL,
    interest_rate DECIMAL(5, 2) NOT NULL
);

INSERT INTO repayment_period (months, interest_rate) VALUES
(12, 6.5),
(24, 6.5),
(36, 6.5);


-- do not create the below table, intension is to save the data once the user chooses a specific plan. future feature
CREATE TABLE contract_repayment (
    repayment_id INT PRIMARY KEY AUTO_INCREMENT,
    device_id INT,
    period_id INT,
    total_repayment_amount DOUBLE,
    monthly_repayment_amount DOUBLE,
    total_interest_amount DOUBLE,
    start_date DATE,
    FOREIGN KEY (device_id) REFERENCES device (device_id),
    FOREIGN KEY (period_id) REFERENCES repayment_period (period_id)
);
Drop TABLE contract_repayment;

-- query those tables to verify