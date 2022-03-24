CREATE TABLE PRODUCT (id bigint auto_increment, type varchar(255), measure varchar(255), name varchar(255), quantity integer, primary key (id));

INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('VEGETABLE', 'QUANTITY', 'Carrot',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('MEAL', 'KILOGRAMS', 'Meat',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('VEGETABLE', 'QUANTITY', 'Cabbage',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('FRUIT', 'QUANTITY', 'Banana',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('FRUIT', 'QUANTITY', 'Apple',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('VEGETABLE', 'KILOGRAMS', 'Grain',100);
INSERT INTO PRODUCT(type,measure,name,quantity)  VALUES('LIQUID', 'LITERS', 'Water',100);

CREATE TABLE ANIMAL (id bigint auto_increment, is_predator boolean not null, kind_of_animal varchar(255), name varchar(255), primary key (id));

INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( false, 'MAMMAL', 'Monkey');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( false, 'MAMMAL', 'Rabbit');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( true, 'BIRD', 'Eagle');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( true, 'MAMMAL', 'Tiger');
INSERT INTO ANIMAL(is_predator,kind_of_animal,name)  VALUES( false, 'MAMMAL', 'Horse');


--CREATE TABLE animal_products (animal_id bigint not null, products_id bigint not null);

-- Обезьяна (банан, яблоко)
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(1,4);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(1,5);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(1,7);
-- Заяц (морковь, капуста)
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(2,1);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(2,3);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(2,7);
-- Орёл (мясо, зерно, яблоко)
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(3,2);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(3,6);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(3,5);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(3,7);
-- Тигр (мясо)
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(4,2);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(4,7);
-- Лошадь (зерно, яблоко, морковь).
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(5,6);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(5,5);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(5,1);
-- INSERT INTO animal_products(animal_id,products_id,norm) VALUES(5,7);


