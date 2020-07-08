# HKTV-Warehose-Inventory-sample-app
Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.hktv.warehouse.WarehouseApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
Make sure change the config `application.yml` to connect the SQL. (e.g: user name, password and port)
## Daily
Day 1: 
Start design the backend system using TDD.
Think the test case before implementation.
Do the test by using postman.
Finish `Product` and `Location` class, successfully connect the database.
<br />

Day 2: Finish the `Inventory` function.
<br />

Day 3: Test the system whether it can handle the exceptional case.