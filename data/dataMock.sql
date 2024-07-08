CREATE DATABASE `MOCK`;
USE `MOCK`;
-- Bảng Roles
CREATE TABLE `roles` (
  role_id INT PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(50) NOT NULL UNIQUE
);
select * from roles;
-- Thêm các vai trò mặc định vào bảng Roles
INSERT INTO `roles` (role_name) VALUES ('admin');
INSERT INTO `roles` (role_name) VALUES ('librarian');
INSERT INTO `roles` (role_name) VALUES ('user');
-- Bảng Users
CREATE TABLE `users` (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  full_name VARCHAR(100) NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (role_id) REFERENCES roles(role_id),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Bảng Books
CREATE TABLE `books` (
  book_id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  genre VARCHAR(50) NOT NULL,
  publication_year INT NOT NULL,
  quantity INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
INSERT INTO `books` (title, author, genre, publication_year, quantity, created_at, updated_at)
VALUES ('Sample Book Title', 'Sample Author', 'Fiction', 2023, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
select * from books;
-- Bảng Notifications
CREATE TABLE `notifications` (
  notification_id INT PRIMARY KEY AUTO_INCREMENT,
  notification_content VARCHAR(255) NOT NULL,
  user_id INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);
-- Bảng BorrowRecords
CREATE TABLE `BorrowRecords` (
  borrow_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  book_id INT NOT NULL,
  borrow_date DATE NOT NULL,
  due_date DATE NOT NULL,
  return_date DATE DEFAULT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (book_id) REFERENCES books(book_id)
);
