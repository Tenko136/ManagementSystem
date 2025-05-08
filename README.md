### Разработана backend-часть системы управления банковскими картами. Система  обеспечивает создание, управление и просмотр данных о банковских картах, а также выполнение операций между картами пользователя. ###

*Использована БД MySQL в контейнере Docker. Настройки контейнера указаны в файле docker-compose.yml*

*Запуск Docker-compose по команде:*
```git
docker-compose up
```

*Liquibase запускается при старте приложения. 
Добавлены стартовые пользователи Администратор + 2 Пользователя, карты пользователей*

*Настройки подключения к БД в файле application.properties*

*Подключен [swagger](http://localhost:8080/swagger-ui/index.html)*

*Подключен Spring Security и JWT. Авторизация по email, пароль равен email*

Для получения Bearer-Token:
```java
AuthController.authenticateUser()
```
```json
{
"email": "admintest",
"password": "admintest"
}
```

### Описание приложения: ###

#### Администратор: ####

- Просмотр всех карт, поиск по номеру карты в т.ч параметризированный список и постраничная выдача:
```java
CardController.findAllCards()
```
Пример:
```json
{
  "cardNumber": "1234123412341234",
  "pageSize": 2,
  "pageNumber": 1
}
```

- Сохранение новой карты, изменение данных карты, изменение статуса карты:
```java
CardController.saveCard()
```
Пример:
```json
{
  "id": 1,
  "userId": 1,
  "number": "1234123412341234",
  "expirationDate": "2025-05-08",
  "status": "ACTIVE",
  "balance": 1000
}
```
- Удаление карты:
```java
CardController.deleteCard()
```
- Поиск всех пользователей:
```java
UserController.findUsers()
```
- Сохранение пользователя, изменение данных пользователя:
```java
UserController.saveUser()
```
Пример:
```json
{
"id": 1,
"name": "Full name",
"email": "name@mail.com",
"password": "name@mail.com",
"role": "ADMIN"
}
```
- Удаление пользователя:
```java
UserController.deleteUser()
```

#### Пользователь: ####

- Просмотр своих карт, в т.ч баланса, ограничение видимости номера карты в формате **** **** **** 1234:
```java
CardController.findAllCards()
```
Запрос на блокировку карты:
```java
CardController.cardBlockingRequest()
```
Пример:
```json
{
"CardNumber": "1234123412341234"
}
```
- Перевод средств между своими картами:
```java
CardController.transferAmount()
```
Пример:
```json
{
"cardFrom": "1234123412341234",
"cardTo": "4321432143214321",
"transferAmount": 500
}
```

*Подробное описание задачи в файле Task.md*

