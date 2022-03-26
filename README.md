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