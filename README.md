# Clearing-And-Settlement-Server

**Requirements**
MySQL
Maven
Spring-boot


**Steps**

Clone the repo

git clone 


DB Steps
1. Create a mysql db named `clearinghouse`
create database clearinghouse;

2. Create a user
create user 'root'@'%' identified by '1234'; -- If not already have root user

3. Grant db access to this user; 
grant all on clearinghouse.* to 'root'@'%'; -- If not already have root user 


**Run server using maven**

./mvnw spring-boot:run

**Generating Trades**

Send a request to localhost:8080/trades/generate

**Fetch Trades in JSON format**

Get Request to localhost:8080/trades/fetch

**For any configuration**

find application.properties file

