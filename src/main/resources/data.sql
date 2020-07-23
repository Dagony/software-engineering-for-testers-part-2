DROP TABLE IF EXISTS billionaires;

CREATE TABLE temperatures (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  degrees INT NOT NULL
);

INSERT INTO temperatures (name, degrees) VALUES
  ('temp 1', 15),
  ('temp 2', 30)
