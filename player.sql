
--Create table
CREATE TABLE player (
  id INT,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  codename VARCHAR(30)
);

--Place first record into table
INSERT INTO player (id, first_name, last_name, codename)
VALUES (1, 'Jim', 'Strother', 'Opus');
VALUES (2, 'William', 'Z', 'A');
VALUES (3, 'James', 'Y', 'B');
VALUES (4, 'Benjamin', 'X', 'C');
VALUES (5, 'Amelia', 'W', 'D');
