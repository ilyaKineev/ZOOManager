#И тестовое ⬇️
###Учёт ресурсов зоопарка

##Сущности

###Животное
Состоит из полей: 
* Название
* Вид (млекопитающее/птица)
* Признак хищника (да/нет).

###Продукты
Состоит из полей: 
* Название
* Текущее количество
* Единица измерения(кг/шт/л)
* Тип (овощ/фрукт/мясо/жидкость)
##Требования
###1. Каждое животное может употреблять несколько вариантов Продуктов.
###2. Для каждого животного надо указать его ежедневную норму потребления каждого продукта. 
###3. Тестовые данные такие:
   * Животные (Обезьяна, Заяц, Орёл, Тигр, Лошадь).
   * Продукты (Морковь - шт, Мясо- кг, Капуста - шт, Банан - шт, Яблоко - шт, Зерно - кг, Вода - л).
   * Воду пьют все животные, а также дополнительно едят: 
     * Обезьяна (банан, яблоко), 
     * Заяц (морковь, капуста), 
     * Орёл (мясо, зерно, яблоко), 
     * Тигр (мясо), 
     * Лошадь (зерно, яблоко, морковь). 
   * Нормы ежедневного потребления указать разные, произвольные. 
   Текущее количество также разное, но зерна должно быть много, яблок - 0, мяса - мало.
###4. Разработать REST API, которое позволяет:
   1. ~~Получить информацию о всех животных.~~
   2. ~~Получить информацию о всех продуктах.~~
   3. ~~Получить информацию о животном по id.~~
   4. ~~Получить информацию о продукте по id.~~
   ~~5. Получить информацию о питании животных на 7 дней от заданной даты. Название продукта, сколько продукта надо на 7 дней, сколько продукта всего есть, сколько его не хватает (если продукта достаточно, то вернуть null), единица измерения.~~
###5. Необязательно:
   1. ~~Получить информацию о животных, с перечислением продуктов их питания.~~ 
      1. ~~Название животного, вид, список продуктов (название, тип, потребление, единица измерения).~~ 
      2. Необязательные параметры запроса: вид животного, тип продукта, хищник или нет и произвольная строка с названием животного (строка может не содержать полное название животного). 
      3. Усложнение: добавить пагинацию.
   2. ~~Создание нового животного, удаление животного по id.~~  
      1. ~~Усложнение: удаление нескольких животных, всех животных сразу.~~    
   3. ~~Изменение ежедневной нормы для животного по его id.~~
   4. ~~Создание нового продукта, удаление продукта по id.~~
      1. ~~Усложнение: удаление нескольких продуктов, всех продуктов сразу.~~
   5. ~~Назначение продукта животному.~~ 
      1. ~~Усложнение: назначение нескольких продуктов одному животному сразу.~~
   6. ~~Изменение количества продукта по его id.~~
###6. JAVA 11, REST API, JPA, named queries, Criteria API (там где он нужен). БД любая, можно H2, главное сделать простое разворачивание таблиц БД и заполнение их тестовыми данными (плюс: использование liquibase).


##ZOOManager
##Make things easier for your teammates with a complete collection description.
#Animals
GET
- Get_All_Animals
``http://localhost:8080/zoo/animals``

GET
- Get_Info_Animal_By_ID
``http://localhost:8080/zoo/animals/5``

POST
- Create_New_Animal
``http://localhost:8080/zoo/animals``
Body raw json

``{
"name": "Tigукеerrr",
"kindOfAnimal": "MAMMAL",
"predator": true
}`` 

PUT
- Update_Animal
``http://localhost:8080/zoo/animals/6``
Body raw json

``{
"name": "HorseNew",
"kindOfAnimal": "MAMMAL",
"predator": true
}``

DEL
- Remove_Animal_by_ID
``http://localhost:8080/zoo/animals/3``

DEL
- Remove_Group_Animals
``http://localhost:8080/zoo/animals/group``
Body raw json

``[
{
"id": 4,
"name": "Tiger",
"kindOfAnimal": "MAMMAL",
"products": [
{
"id": 2,
"name": "Meat",
"quantity": 50,
"measure": "KILOGRAMS",
"type": "MEAL"
},
{
"id": 7,
"name": "Water",
"quantity": 100,
"measure": "LITERS",
"type": "LIQUID"
}
],
"predator": true
},
{
"id": 5,
"name": "Horse",
"kindOfAnimal": "MAMMAL",
"products": [
{
"id": 6,
"name": "Grain",
"quantity": 1000,
"measure": "KILOGRAMS",
"type": "VEGETABLE"
},
{
"id": 5,
"name": "Apple",
"quantity": 0,
"measure": "QUANTITY",
"type": "FRUIT"
},
{
"id": 1,
"name": "Carrot",
"quantity": 100,
"measure": "QUANTITY",
"type": "VEGETABLE"
},
{
"id": 7,
"name": "Water",
"quantity": 100,
"measure": "LITERS",
"type": "LIQUID"
}
],
"predator": false
}
]``

DEL
- Remove_All_Animals
`http://localhost:8080/zoo/animals`
Products

GET 
- Get_All_Products
`http://localhost:8080/zoo/products`

GET
- Get_Info_Product_By_ID
`http://localhost:8080/zoo/products/1`

POST
- Create_New_Product
`http://localhost:8080/zoo/products`

Body raw json
`{
"type": "VEGETABLE",
"name": "Apple",
"quantity": 100,
"measure": "KILOGRAMS"
}`

PUT
- Update_Product
`http://localhost:8080/zoo/products/1`
Body raw 
json
`{
"name": "Apple",
"quantity": 100,
"measure": "KILOGRAMS",
"type": "VEGETABLE"
}`

DEL
- Remove_Product_By_ID
`http://localhost:8080/zoo/products/7`

DEL
- Remove_Group_Products
`http://localhost:8080/zoo/products/group`

Body raw json
`[
{
"id": 1,
"name": "Apple",
"quantity": 100,
"measure": "KILOGRAMS",
"type": "VEGETABLE"
},
{
"id": 2,
"name": "Apple",
"quantity": 100,
"measure": "KILOGRAMS",
"type": "VEGETABLE"
},
{
"id": 3,
"name": "Apple",
"quantity": 100,
"measure": "KILOGRAMS",
"type": "VEGETABLE"
}
]`

DEL
- Remove_All_Products
`http://localhost:8080/zoo/products`

GET
- Get_Products_By_One_Week
`http://localhost:8080/zoo/week`
 
GET
- Get_All_Info_by_ZOO
`http://localhost:8080/zoo/info`

PUT
- Update_Quantity_By_id
`http://localhost:8080/zoo/quantity?id=1&quantity=1500`

PUT
- Update_Norm_By_id
`http://localhost:8080/zoo/norm?id=1&norm=15`
 
PUT
- Set_Product_For_An_Animal
`http://localhost:8080/zoo/product?id=1&product=5`

Body raw json
`{
"name": "Meat",
"quantity": 50,
"measure": "KILOGRAMS",
"type": "MEAL"
}`

PUT
- Set_Group_Product_For_An_Animal
`http://localhost:8080/zoo/products?id=1&product=5,2,1`

Body raw json
`{
"name": "Meat",
"quantity": 50,
"measure": "KILOGRAMS",
"type": "MEAL"
}`