DROP TABLE IF EXISTS book_tags;

CREATE TABLE book_tags (
	isbn_13 VARCHAR (13),
	tag_name VARCHAR (32), 
	PRIMARY KEY (isbn_13, tag_name)
);

INSERT INTO book_tags VALUES (
	'1111111111111',	-- isbn_13
	'fantasy'			-- tag_name
);