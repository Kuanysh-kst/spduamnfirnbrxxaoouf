
##Как установить и настроить проект:
Чтобы скачать проект вводим команду:
```shell
git clone git@github.com:Kuanysh-kst/spduamnfirnbrxxaoouf.git
```

* Если вы используюете Intellij IDEA , то перейдите в: 
```
File/Project Structure...
``` 
и там выбирите в Projects SDK : corretto-17 Amazon Corretto
* Далее для настройки Gradle JVM перейдите в:
```
Settings.../Build,.../Build Tools/Gradle
```
и там выбираем corretto-17 Amazon Corretto

##Как запустить проек локально:
* У вас должен быть установлен docker, для запуска докера в проекте введите 
```
docker-compose up -d
```
чтобы узнать запустились ли контейнеры введите 
``` 
docker ps
```
вы должны будете увидеть что то подобное:
```
CONTAINER ID   IMAGE                       COMMAND                  CREATED         STATUS                PORTS                                                        NAMES
d2914d7894be   mongo:6-jammy               "docker-entrypoint.s…"   4 seconds ago   Up 3 seconds          0.0.0.0:27017->27017/tcp, :::27017->27017/tcp                spduamnfirnbrxxaoouf-mongodb-1
5458005cd2bc   bitnami/postgresql:latest   "/opt/bitnami/script…"   4 seconds ago   Up 3 seconds          0.0.0.0:5432->5432/tcp, :::5432->5432/tcp                    spduamnfirnbrxxaoouf-postgres-1
```

