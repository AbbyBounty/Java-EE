CREATE DATABASE ojee_db;

USE ojee_db;

CREATE TABLE users
(
	full_name VARCHAR(256),
	email VARCHAR(256),
	password VARCHAR( 256 ),
	birth_date DATE
);

INSERT INTO users
VALUES
('Akash Shelke','akash@gmail.com','akash','1992-06-01'),
('Yogesh Kolhe', 'yogesh@gmail.com','yogesh','1989-06-01'),
('Sandeep Kulange','sandeep@gmail.com','sandeep','1983-06-01'),
('Nilesh Ghule','nilesh@gmail.com','nilesh','1984-06-01');

SELECT * FROM users;