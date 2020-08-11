# Проект автоматизации тестирования сайта Geekbrains

Это учебный проект, созданный в рамках курса "ООП в Java".

Автотесты написаны для сайта https://geekbrains.ru/

  - [Используемые библиотеки](#используемые-библиотеки)
  - [Установленные плагины](#установленные-плагины)
  - [Запуск тестов](#запуск-тестов)
  - [Реализованные тесты](#реализованные-тесты)

## Используемые библиотеки

  - [Selenium Java - 3.141.59](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59)
  - [JUnit Jupiter (Aggregator) - 5.6.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.6.2)
  - [Hamcrest - 2.2](https://mvnrepository.com/artifact/org.hamcrest/hamcrest/2.2)
  - [Allure JUnit 5 Integration - 2.13.5](https://mvnrepository.com/artifact/io.qameta.allure/allure-junit5/2.13.5)
  - [WebDriverManager - 4.1.0](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/4.1.0)
  - [Project Lombok - 1.18.12](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.12)

## Установленные плагины

 - [Allure Maven - 2.10.0](https://mvnrepository.com/artifact/io.qameta.allure/allure-maven/2.10.0)
 - [Maven Surefire Plugin - 2.22.2](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin/2.22.2)
 - [AspectJ Weaver - 1.9.4](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver/1.9.4)
 
## Запуск тестов

Запуск тестов и вывод результатов в отчет Allure.
```
mvn clean test allure:serve
``` 

## Реализованные тесты
- AuthorizationTest - проверка работы формы авторизации и поисковых фильтров.
- NavigationTest - проверка работы меню навигации.
- SearchTest - проверка работы поиска на сайте.
