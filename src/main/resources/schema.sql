CREATE TABLE users (
    id IDENTITY,
    name CHAR NOT NULL
);

CREATE TABLE matches (
    id IDENTITY NOT NULL PRIMARY KEY,
    user1 INT,
    user2 INT,
    user1Hand CHAR,
    user2Hand CHAR,
    isActive BOOLEAN
);

CREATE TABLE matchinfo (
    id IDENTITY,
    user1 INT,
    user2 INT,
    user1Hand CHAR,
    isActive BOOLEAN
);
