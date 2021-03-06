[![Build Status](https://app.travis-ci.com/4rl1996/socks.svg?branch=main)](https://app.travis-ci.com/4rl1996/socks)

Приложение основано на Spring, развернуто на сервисе Sprintbox.

СУБД: PostgreSQL, поднимается в докер-контейнере. 
Для версионирования БД используется Flyway.

Используется Travis-CI для проверки корректности сборки проекта.

Методы:

POST http://185.185.69.237:8080/api/socks/income - регистрация прихода носков на склад.

POST http://185.185.69.237:8080/api/socks/outcome - регистрация отпуска носков со склада.
Если запрашивать количество носков большее, чем есть на складе, вернется HTTP 400.

Параметры передаются в виде JSON-объекта:

![изображение](https://user-images.githubusercontent.com/84574006/136523492-9f95a5a3-a4e5-4c04-8efa-53a9001a2d7f.png)


GET http://185.185.69.237:8080/api/socks - возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса.
Если по переданным параметрам количество носков = 0, или таких носков вообще нет, то вернется 0.

Реализована валидация параметров запроса. Пример:
Состав хлопка: 1%
![изображение](https://user-images.githubusercontent.com/84574006/136519480-3236e327-deed-4647-851b-00e32bfe2a3b.png)
Состав хлопка: -1% 
![изображение](https://user-images.githubusercontent.com/84574006/136519538-4b106b7e-162a-4c8c-8f1a-d4ab9081f811.png)

