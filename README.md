
## Как установить и настроить проект:
### 1.1 Чтобы скачать проект вводим команду:
```shell
git clone git@github.com:Kuanysh-kst/spduamnfirnbrxxaoouf.git
```

### 1.2 Если вы используюете Intellij IDEA , то перейдите в: 
```
File/Project Structure...
``` 
и там выбирите в Projects SDK : corretto-17 Amazon Corretto
### 1.3 Далее для настройки Gradle JVM перейдите в:
```
Settings.../Build,.../Build Tools/Gradle
```
и там выбираем corretto-17 Amazon Corretto

## Как запустить проек локально:
### 2.1 У вас должен быть установлен docker, для запуска докера в проекте введите 
```
docker-compose up -d
```
### 2.2 чтобы узнать запустились ли контейнеры введите 
``` 
docker ps
```
вы должны будете увидеть что то подобное:
```
CONTAINER ID   IMAGE                       COMMAND                  CREATED         STATUS                PORTS                                                        NAMES
d2914d7894be   mongo:6-jammy               "docker-entrypoint.s…"   4 seconds ago   Up 3 seconds          0.0.0.0:27017->27017/tcp, :::27017->27017/tcp                spduamnfirnbrxxaoouf-mongodb-1
5458005cd2bc   bitnami/postgresql:latest   "/opt/bitnami/script…"   4 seconds ago   Up 3 seconds          0.0.0.0:5432->5432/tcp, :::5432->5432/tcp                    spduamnfirnbrxxaoouf-postgres-1
```
### 2.3 если все контейнеры запущены можно будет запустить проект
* команда чтобы запустить проект: 
```
./gradlew bootRun
```
Ждём, когда запуститься сервер. После запуска сервера,должны появится логи:
```
tation=JAVA_LEGACY, serverApi=null, autoEncryptionSettings=null, contextProvider=null}
2023-10-23T17:50:57.409+06:00  INFO 79818 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=17, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=9157193}
2023-10-23T17:50:57.715+06:00  WARN 79818 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-10-23T17:50:58.020+06:00  INFO 79818 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-23T17:50:58.025+06:00  INFO 79818 --- [           main] c.e.s.DemoApplication                    : Started DemoApplication in 2.421 seconds (process running for 2.596)
```
заходим в браузере по адресу: http://localhost:8080
* Видим что все работает, а иммено видны вот эти ссылки
```
_links	
mongoUserDTOes	
href	"http://localhost:8080/mongoUserDTOes{?page,size,sort}"
templated	true
userDTOes	
href	"http://localhost:8080/userDTOes{?page,size,sort}"
templated	true
profile	
href	"http://localhost:8080/profile"
```

### 2.4 После этого можно открыть файл testRequests.postman_collection.json для проверки сервера
* в этой коллекций есть основные запросы на GET ,DELETE и PUT. Директория файла:
```
spduamnfirnbrxxaoouf/postman/testRequests.postman_collection.json
```
# Как подключится к базе данных
Перед подключением нужно обязательно сделать docker-compose up в проекте
### 3.1 PostgreSql
* Для PostgreSql я использую Dbeaver , чтобы подключится к базе нужно:
* Зайти в Dbeaber нажать на кнопку новое соединение(Shift+ctl+N), выбрать PostgreSql,выбрать URL,ввести в строку URL:
```
jdbc:postgresql://localhost:5432/postgres
```
в строку пароль:
```
password
```
и нажимаем кнопку Готово
### 3.2 MongoDB
* Для MongoDB я использую MongoDB Compass, для подключения вводим в строку URI:
```
mongodb://localhost:27017/db
```
и нажимаем кнопку Connect

### Описание контороллеров
В контроллере UserController присутствуют методы с различными аннотациями, обрабатывающие HTTP-запросы. Вот описание каждого метода и их входных параметров:

    findById - Получает пользователя по идентификатору.
        Входные параметры: int id - идентификатор пользователя.

    findByFirstPhone - Получает пользователя по первому номеру телефона.
        Входные параметры: String phoneNumber - первый номер телефона пользователя.

    findBySecondPhone - Получает пользователя по второму номеру телефона.
        Входные параметры: String phoneNumber - второй номер телефона пользователя.

    findAllUsers - Получает всех пользователей с использованием фильтра.
        Входные параметры: Filter filter - объект фильтра, содержащий лимит и смещение.

    updateById - Обновляет пользователя по идентификатору.
        Входные параметры: Long id - идентификатор пользователя, UserDTO updatedUser - объект, содержащий обновленные данные пользователя.

    updateByFirstPhone - Обновляет пользователя по первому номеру телефона.
        Входные параметры: String phoneNumber - первый номер телефона пользователя, UserDTO updatedUser - объект, содержащий обновленные данные пользователя.

    updateBySecondPhone - Обновляет пользователя по второму номеру телефона.
        Входные параметры: String phoneNumber - второй номер телефона пользователя, UserDTO updatedUser - объект, содержащий обновленные данные пользователя.

    deleteById - Удаляет пользователя по идентификатору.
        Входные параметры: int id - идентификатор пользователя.

    deleteByFirstPhone - Удаляет пользователя по первому номеру телефона.
        Входные параметры: String phoneNumber - первый номер телефона пользователя.

    deleteBySecondPhone - Удаляет пользователя по второму номеру телефона.
        Входные параметры: String phoneNumber - второй номер телефона пользователя.

* Контроллер MongoUserController аналогичен


