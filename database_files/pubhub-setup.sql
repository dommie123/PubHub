-- Database: PubHub

DROP DATABASE IF EXISTS "PubHub";
DROP TABLE IF EXISTS book_tags;
DROP TABLE IF EXISTS books;

CREATE DATABASE "PubHub"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
	AUTOCOMMIT = ON
    CONNECTION LIMIT = -1;
	
CREATE TABLE book_tags (
	isbn_13 VARCHAR (13) NOT NULL UNIQUE,
	tag_name VARCHAR (32), 
	PRIMARY KEY (isbn_13, tag_name)
);

INSERT INTO book_tags VALUES (
	'1111111111111',	-- isbn_13
	'fantasy'			-- tag_name
);
	
CREATE TABLE books (
  isbn_13 varchar (13) PRIMARY KEY,
  title varchar (100),
  author varchar (80),
  publish_date date,
  price decimal (6,2),
  CONTENT bytea,
  FOREIGN KEY (isbn_13) REFERENCES book_tags(isbn_13)
	  
);

INSERT INTO books VALUES (
  '1111111111111',          	-- id
  'The Adventures of Steve',    -- title
  'Russell Barron', 			-- author
  current_date,    				-- publishDate
  123.50,   					-- price
  null							-- blob
);

