# user-api-backend-rest-api using Spring boot and Spring security!!
I have choosen spring boot frame work to design this API beacuse
Spring Boot is a powerful framework that simplifies the process of developing production-ready applications with minimal setup and boilerplate code. Here's why we chose Spring Boot for developing this API

# Rapid Development:
Spring Boot provides a range of pre-configured components and conventions, allowing developers to focus on business logic rather than infrastructure setup.
# Embedded Web server:
Spring Boot includes an embedded web server (Tomcat, Jetty, or Undertow) which eliminates the need to deploy the application on a separate server.
# Auto configuaration
Spring Boot's auto-configuration automatically configures common application settings based on dependencies and project structure.
# Easy Dependency Management:
Spring Boot manages dependencies using a simple build configuration (Gradle or Maven), reducing version conflicts and making dependency management hassle-free.
# RESTful APIs:
Spring Boot simplifies the development of RESTful APIs using annotations and conventions, making it easy to create, test, and document APIs.
# Database Integration:
Spring Boot seamlessly integrates with various databases, including MySQL, through its powerful data access abstractions.

# Data base Schema :
As in the API documentation it is mentioned that we need to store the user specific details into the data base and also we need to let the user to store data in the form of key-value pari. so I have created two tables
one is storing for user details and another one is storing data wants save by the specific user. In the API documentation is has been stated that Many users can store the same key but the same user cannot store the same key so that's why I have established One-To-Many relation between thse two tables and the schema of the tables are given below.
# Table Schema Scripts:
create database user_backend_db;
use user_backend_db;

CREATE TABLE person(
	id int not null primary key auto_increment,
    username varchar(50) not null,
    email varchar(60) not null,
    password varchar(50) not null,
    full_name varchar(70) not null,
    age int not null,
    gender varchar(20) not null
);

CREATE TABLE data(
	id int primary key not null auto_increment,
	key_val varchar(40) ,
    val varchar(50) ,
    person_id int not null,
    foreign key(person_id) references person(id)
);
# Instructions for setting up the code.
->first download the code form my git hub repository set import the dowloaded folder in any of your favourite IDE's like Intellij or Eclipse or NetBeans.


->Then create the Data base as mentioned above. and Run the SQL Scripts in MYSQL work bench. Then Give the name of the Database of credintails of the data base in "src/main/resources/application.properties" file.

-> After creating the Database go to src/main/java Open the class Named with "UserAppBackendRestApplication". Right click and select Run on server or run as spring boot app.
"# REST-API" 
