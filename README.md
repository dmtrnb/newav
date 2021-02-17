# Test for Advertising

Демо-сервис объявлений на Spring Boot.

Запуск: docker-compose up

Swagger-документация: http://localhost:8080/swagger-ui.html

[Скриншот документации](/wiki_resources/swagger.png).

Три метода: add, findById и findAll(Pageable).

Примеры запросов:

http://localhost:8080/findById/2
http://localhost:8080/findById/2?fields=photos
http://localhost:8080/findById?id=2&fields=photos,description
http://localhost:8080/findAll
http://localhost:8080/findAll?page=0&size=2&sort=DESC&column=price
curl -X POST -H "Content-Type: application/json" -d '{"title":"Yellow","description":"is new red","price":14.88}' http://localhost:8080/add
curl http://localhost:8080/findAll
