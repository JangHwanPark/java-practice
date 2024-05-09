CREATE DATABASE db2451506_user_management;

CREATE TABLE admin
(
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(100),
    email    VARCHAR(100),
    phone    VARCHAR(15),
    password VARCHAR(50)
);

CREATE TABLE customer
(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100),
    address     VARCHAR(255),
    email       VARCHAR(100),
    phone       VARCHAR(15)
);



CREATE TABLE product
(
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    model      VARCHAR(100),
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
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    FOREIGN KEY (product_id) REFERENCES product (product_id),
    FOREIGN KEY (admin_id) REFERENCES admin (admin_id)
);

-- Insert Dummy data
INSERT INTO admin (name, email, phone, password)
VALUES ('John Doe', 'johndoe@example.com', '010-1234-5678', 'password123'),
       ('Jane Smith', 'janesmith@example.com', '010-2345-6789', 'password234'),
       ('Alice Johnson', 'alicejohnson@example.com', '010-3456-7890', 'password345'),
       ('Bob Brown', 'bobbrown@example.com', '010-4567-8901', 'password456'),
       ('Carol White', 'carolwhite@example.com', '010-5678-9012', 'password567'),
       ('David Wilson', 'davidwilson@example.com', '010-6789-0123', 'password678'),
       ('Eve Taylor', 'evetaylor@example.com', '010-7890-1234', 'password789'),
       ('Frank Moore', 'frankmoore@example.com', '010-8901-2345', 'password890'),
       ('Grace Lee', 'gracelee@example.com', '010-9012-3456', 'password901'),
       ('Henry Martin', 'henrymartin@example.com', '010-0123-4567', 'password012');

INSERT INTO customer (name, address, email, phone)
VALUES ('Kim Young', '123 Seoul Lane', 'kimyoung@example.com', '010-1111-2222'),
       ('Lee Sun', '456 Busan Street', 'leesun@example.com', '010-2222-3333'),
       ('Park Jin', '789 Incheon Blvd', 'parkjin@example.com', '010-3333-4444'),
       ('Choi Kyung', '321 Daegu Avenue', 'choikyung@example.com', '010-4444-5555'),
       ('Jung Hwan', '654 Gwangju Road', 'junghwan@example.com', '010-5555-6666'),
       ('Yoon Soo', '987 Daejeon Path', 'yoonsoo@example.com', '010-6666-7777'),
       ('Kang Min', '135 Ulsan Way', 'kangmin@example.com', '010-7777-8888'),
       ('Moon Ji', '246 Jeju Street', 'moonji@example.com', '010-8888-9999'),
       ('Kwon Bo', '357 Suwon Lane', 'kwonbo@example.com', '010-9999-1111'),
       ('Han Seo', '468 Changwon Blvd', 'hanseo@example.com', '010-1111-9999');

INSERT INTO product (model, price)
VALUES ('Lexus ES 350', 35000.00),
       ('Lexus RX 350', 40000.00),
       ('Lexus NX 300', 36000.00),
       ('Lexus IS 300', 33000.00),
       ('Lexus LX 570', 90000.00),
       ('Lexus GX 460', 50000.00),
       ('Lexus LS 500', 75000.00),
       ('Lexus RC 350', 44000.00),
       ('Lexus UX 200', 32000.00),
       ('Lexus LC 500', 92000.00);

INSERT INTO orders (customer_id, product_id, admin_id, purchase_date, service_due_date)
VALUES (1, 1, 1, '2023-05-01', '2024-05-01'),
       (2, 2, 2, '2023-06-01', '2024-06-01'),
       (3, 3, 3, '2023-07-01', '2024-07-01'),
       (4, 4, 4, '2023-08-01', '2024-08-01'),
       (5, 5, 5, '2023-09-01', '2024-09-01'),
       (6, 6, 6, '2023-10-01', '2024-10-01'),
       (7, 7, 7, '2023-11-01', '2024-11-01');