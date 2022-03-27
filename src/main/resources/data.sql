CREATE TABLE PRODUCT (id bigint auto_increment, type varchar(255), measure varchar(255), name varchar(255), quantity integer, primary key (id));

INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('VEGETABLE', 'QUANTITY', 'Carrot',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('MEAL', 'KILOGRAMS', 'Meat',50);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('VEGETABLE', 'QUANTITY', 'Cabbage',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('FRUIT', 'QUANTITY', 'Banana',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('FRUIT', 'QUANTITY', 'Apple',0);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('VEGETABLE', 'KILOGRAMS', 'Grain',1000);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('LIQUID', 'LITERS', 'Water',100);

CREATE TABLE ANIMAL (id bigint auto_increment, is_predator boolean not null, kind_of_animal varchar(255), name varchar(255), primary key (id));

INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( false, 'MAMMAL', 'Monkey');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( false, 'MAMMAL', 'Rabbit');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( true, 'BIRD', 'Eagle');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( true, 'MAMMAL', 'Tiger');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( false, 'MAMMAL', 'Horse');


CREATE TABLE DIET (id bigint auto_increment, animal_id bigint, product_id bigint, norm integer, FOREIGN KEY (animal_id) REFERENCES ANIMAL (id) ON DELETE CASCADE, FOREIGN KEY (product_id) REFERENCES PRODUCT (id) ON DELETE CASCADE);

-- Обезьяна (банан, яблоко)
INSERT INTO DIET(animal_id,product_id,norm) VALUES(1,4,1);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(1,5,6);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(1,7,1);
-- Заяц (морковь, капуста)
INSERT INTO DIET(animal_id,product_id,norm) VALUES(2,1,5);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(2,3,6);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(2,7,4);
-- Орёл (мясо, зерно, яблоко)
INSERT INTO DIET(animal_id,product_id,norm) VALUES(3,2,3);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(3,6,5);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(3,5,7);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(3,7,3);
-- Тигр (мясо)
INSERT INTO DIET(animal_id,product_id,norm) VALUES(4,2,4);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(4,7,1);
-- Лошадь (зерно, яблоко, морковь).
INSERT INTO DIET(animal_id,product_id,norm) VALUES(5,6,5);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(5,5,9);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(5,1,8);
INSERT INTO DIET(animal_id,product_id,norm) VALUES(5,7,4);


