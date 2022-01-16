-- Spring Security User user/pass
/*
INSERT INTO users (username, password, enabled)
  values ('izzet', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a', 1);

INSERT INTO authorities (username, authority)
  values ('izzet', 'ROLE_USER');
*/

-- Default Categories
INSERT INTO category (description) VALUES ('American');
INSERT INTO category (description) VALUES ('Italian');
INSERT INTO category (description) VALUES ('Mexican');
INSERT INTO category (description) VALUES ('Turkish');
INSERT INTO category (description) VALUES ('Chinese');

-- Default Units
INSERT INTO unit_of_measure (uom) VALUES ('Teaspoon');
INSERT INTO unit_of_measure (uom) VALUES ('Tablespoon');
INSERT INTO unit_of_measure (uom) VALUES ('Cup');
INSERT INTO unit_of_measure (uom) VALUES ('Pinch');
INSERT INTO unit_of_measure (uom) VALUES ('Ounce');
INSERT INTO unit_of_measure (uom) VALUES ('Goz karari');
INSERT INTO unit_of_measure (uom) VALUES ('Piece');
INSERT INTO unit_of_measure (uom) VALUES ('Dash');
INSERT INTO unit_of_measure (uom) VALUES ('Clove');
INSERT INTO unit_of_measure (uom) VALUES ('Pound');
INSERT INTO unit_of_measure (uom) VALUES ('Pint');
