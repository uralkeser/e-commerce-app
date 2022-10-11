
## About The Project
This is very simple product management application that you can view, create, update clients, products and categories of products.

All codes were written for the purpose of showing the concepts of Backend Development, Database Systems, Spring Boot, RESTful API, Unit Tests, Log Mechanism, Frontend Development, Dockerizing, SOLID and Clean Code principles with implementing a product management system.

## Api Details
This Project has CRUD operations for Product, Client and Category of Product

## Usage
You can run this app using Docker or locally .

### 1- Run Project Using Docker
Go to
```sh
docker-compose up
```
### 2- Run Project Locally
This Project has two implemented parts(frontend and backend). Before run them properly you need to download some technologies and make some configuration mentioned below.

#### Fronted Requirements
Please download [Node.js](https://nodejs.org)

After download Node.js go to the directory [e-commerce-app]() run this comment below to install node packages which are needed to run properly frontend part of the project.

  ```sh
  npm install
  ```
After downloading packages you can simply run the comment in the same directory written below to run frontend part of the project.

  ```sh
  npm start
  ```

#### Backend Requirements
Please download: [Java](https://www.java.com/), [JDK](https://www.oracle.com/java/technologies/downloads/), [Maven](https://maven.apache.org/), [PostgreSQL](https://www.postgresql.org/)

Dependencies used by Maven are in the file named `./pom.xml`. Configuration is written in `./src/main/resources/application.properties`. 

To run the applications using your local database you must change configurations.

Open File `./src/main/resources/application.properties` .

Replace the following settings according to your database credential.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=123qwe
spring.datasource.driver-class-name=org.postgresql.Driver
```

You must update `docker-compose.yml` according to your database credential aswell.

 
```sh
 mvn spring-boot:run
```

You can use postman collections in `./src/main/resources/static` to test the api. 

### Backend Technologies
- [Java](https://www.java.com)
- [Java Spring Boot Framework](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [Maven](https://maven.apache.org/)
- [Lombok](https://projectlombok.org/)
- [MapStruct](https://mapstruct.org/)
- [JpaRepository](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
- [Slf4j](https://projectlombok.org/api/lombok/extern/slf4j/Slf4j.html)
- [Mockito](https://site.mockito.org/)
- [JUnit](https://junit.org/)

### Frontend Technologies
- [React.js](https://tr.reactjs.org/)
- [React Router](https://v5.reactrouter.com/web/guides/quick-start)
- [React Bootstrap](https://react-bootstrap.github.io/)

### Other Technologies
- [Postman](https://www.postman.com/)
- [Docker](https://www.docker.com/)

## Contact
Osman Ural Keser - [@linkedin](https://www.linkedin.com/in/osmanuralkeser/)  
Mail: osmanuralkeser@gmail.com
