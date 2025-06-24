CREATE DATABASE attendance;

USE attendance;

CREATE TABLE records (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    time DATETIME
);
