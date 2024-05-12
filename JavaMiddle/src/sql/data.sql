CREATE DATABASE db2451506_user_management;

CREATE TABLE admin
(
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(100),
    email    VARCHAR(100),
    phone    VARCHAR(15),
    address  VARCHAR(255),
    role     VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE customer
(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100),
    address     VARCHAR(255),
    email       VARCHAR(100),
    phone       VARCHAR(15),
    role        VARCHAR(50)
);

CREATE TABLE product
(
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    make       VARCHAR(50),
    model      VARCHAR(100),
    year       INT,
    color      VARCHAR(50),
    vin        VARCHAR(50),
    price      DECIMAL(10, 2)
);

CREATE TABLE orders
(
    order_id         INT AUTO_INCREMENT PRIMARY KEY,
    customer_id      INT,
    product_id       INT,
    admin_id         INT,
    purchase_date    DATE,
    service_due_date DATE,
    payment_status   BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    FOREIGN KEY (product_id) REFERENCES product (product_id),
    FOREIGN KEY (admin_id) REFERENCES admin (admin_id)
);


-- Insert Dummy data
INSERT INTO admin (name, email, phone, address, role, password)
VALUES
    ('John Doe', 'johndoe@example.com', '010-1234-5678', '123 Admin Lane', 'Administrator', 'password123'),
    ('Jane Smith', 'janesmith@example.com', '010-2345-6789', '234 Admin Drive', 'Administrator', 'password234'),
    ('Alice Johnson', 'alicejohnson@example.com', '010-3456-7890', '345 Admin Court', 'Administrator', 'password345'),
    ('Bob Brown', 'bobbrown@example.com', '010-4567-8901', '456 Admin Way', 'Administrator', 'password456'),
    ('Carol White', 'carolwhite@example.com', '010-5678-9012', '567 Admin Blvd', 'Administrator', 'password567'),
    ('David Wilson', 'davidwilson@example.com', '010-6789-0123', '678 Admin Street', 'Administrator', 'password678'),
    ('Eve Taylor', 'evetaylor@example.com', '010-7890-1234', '789 Admin Road', 'Administrator', 'password789'),
    ('Frank Moore', 'frankmoore@example.com', '010-8901-2345', '890 Admin Path', 'Administrator', 'password890'),
    ('Grace Lee', 'gracelee@example.com', '010-9012-3456', '901 Admin Avenue', 'Administrator', 'password901'),
    ('Henry Martin', 'henrymartin@example.com', '010-0123-4567', '012 Admin Trail', 'Administrator', 'password012');

INSERT INTO customer (name, address, email, phone, role)
VALUES
    ('Kim Young', '123 Seoul Lane', 'kimyoung@example.com', '010-1111-2222', 'Customer'),
    ('Lee Sun', '456 Busan Street', 'leesun@example.com', '010-2222-3333', 'Customer'),
    ('Park Jin', '789 Incheon Blvd', 'parkjin@example.com', '010-3333-4444', 'Customer'),
    ('Choi Kyung', '321 Daegu Avenue', 'choikyung@example.com', '010-4444-5555', 'Customer'),
    ('Jung Hwan', '654 Gwangju Road', 'junghwan@example.com', '010-5555-6666', 'Customer'),
    ('Yoon Soo', '987 Daejeon Path', 'yoonsoo@example.com', '010-6666-7777', 'Customer'),
    ('Kang Min', '135 Ulsan Way', 'kangmin@example.com', '010-7777-8888', 'Customer'),
    ('Moon Ji', '246 Jeju Street', 'moonji@example.com', '010-8888-9999', 'Customer'),
    ('Kwon Bo', '357 Suwon Lane', 'kwonbo@example.com', '010-9999-1111', 'Customer'),
    ('Han Seo', '468 Changwon Blvd', 'hanseo@example.com', '010-1111-9999', 'Customer');

INSERT INTO product (make, model, year, color, vin, price)
VALUES
    ('Lexus', 'Lexus ES 350', 2021, 'Black', 'VIN001', 35000.00),
    ('Lexus', 'Lexus RX 350', 2022, 'White', 'VIN002', 40000.00),
    ('Lexus', 'Lexus NX 300', 2021, 'Silver', 'VIN003', 36000.00),
    ('Lexus', 'Lexus IS 300', 2020, 'Red', 'VIN004', 33000.00),
    ('Lexus', 'Lexus LX 570', 2023, 'Blue', 'VIN005', 90000.00),
    ('Lexus', 'Lexus GX 460', 2021, 'Grey', 'VIN006', 50000.00),
    ('Lexus', 'Lexus LS 500', 2022, 'Black', 'VIN007', 75000.00),
    ('Lexus', 'Lexus RC 350', 2021, 'White', 'VIN008', 44000.00),
    ('Lexus', 'Lexus UX 200', 2020, 'Blue', 'VIN009', 32000.00),
    ('Lexus', 'Lexus LC 500', 2023, 'Gold', 'VIN010', 92000.00);

INSERT INTO orders (customer_id, product_id, admin_id, purchase_date, service_due_date, payment_status)
VALUES (1, 1, 1, '2023-05-01', '2024-05-01', TRUE),
       (2, 2, 2, '2023-06-01', '2024-06-01', FALSE),
       (3, 3, 3, '2023-07-01', '2024-07-01', TRUE),
       (4, 4, 4, '2023-08-01', '2024-08-01', TRUE),
       (5, 5, 5, '2023-09-01', '2024-09-01', FALSE),
       (6, 6, 6, '2023-10-01', '2024-10-01', TRUE),
       (7, 7, 7, '2023-11-01', '2024-11-01', TRUE);