# JDBC_Assignment3

CREATE TABLE sqlandjava.owners (
owner_id INT NOT NULL AUTO_INCREMENT,
person_id INT NOT NULL,
car_id INT NOT NULL,
PRIMARY KEY(owner_id));

ALTER TABLE sqlandjava.owners 
ADD INDEX FK_people_person_id_idx (person_id ASC) VISIBLE,
ADD INDEX FK_cars_car_id_idx (car_id ASC) VISIBLE;

ALTER TABLE sqlandjava.owners 
ADD CONSTRAINT FK_people_person_id
  FOREIGN KEY (person_id)
  REFERENCES sqlandjava.people (person_id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT FK_cars_car_id
  FOREIGN KEY (car_id)
  REFERENCES sqlandjava.cars (car_id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO sqlandjava.owners (owner_id, person_id, car_id)
VALUES (1, 2, 3),
(2, 1, 4),
(3, 3, 2),
(4, 4, 1);

SELECT * FROM sqlandjava.owners;

GRANT SELECT ON sqlandjava.owners TO karin@localhost;
