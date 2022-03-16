drop table if exists book CASCADE;
CREATE TABLE book (
    book_id BIGINT AUTO_INCREMENT,
    author VARCHAR(255),
    edition VARCHAR(255),
    genre VARCHAR(255),
    isbn VARCHAR(255),
    name VARCHAR(255),
    publisher VARCHAR(255),
    quantity INTEGER NOT NULL,
    PRIMARY KEY (book_id)
);