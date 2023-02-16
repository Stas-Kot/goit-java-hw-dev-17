CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(200),
    password VARCHAR(100),
    role_id INT NOT NULL,
    FOREIGN KEY(role_id) REFERENCES roles(id) ON DELETE CASCADE
);

--CREATE TABLE users (
----    id IDENTITY PRIMARY KEY,
--    name VARCHAR(200) PRIMARY KEY,
--    password VARCHAR(100),
--    role enum('ROLE_USER', 'ROLE_ADMIN') NOT NULL
--);

CREATE TABLE notes (
    note_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(500),
    content VARCHAR(2000),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);