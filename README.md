# RealEstate-API

### Simple real estate registry for buildings

> It provides City, street, number, owner, size, market value, property type, tax and taxValue (which is calculated automaticly)

###### How to create database 

I used postgreSQL and created database through SQL shell psql
so you will have to download it to use this database because its an in-memory database in shell just write

```
CREATE DATABASE realestate;
\du
GRANT ALL PRIVILEGES ON DATABASE "realestate" TO postgres;
\l
\c realestate
```

First line creates database Second line check role names Third Granting privileges this database to your rolename four you can see created database fith to connect to this database

after that in application.properties

you can find it in src -> main -> resources -> application.properties

check if datasource url is correct and use username your rolename so its will be default postgres and password (same password you logged in SQL shell)

You done!

###### Using application 

After creating database, install all dependencies if it doesn't installed automaticly
Right click on pom.xml -> Maven -> Reload Project Wait .. .. .. Wait .. .. .. Done, Good job!
Launch applcation and after that, go to: http://localhost:8080/api/v1/realestate
you will find 2 data already created
to send data use Postman, didn't installed swagger UI only documentation.

if you want to send delete request : 
```
http://localhost:8080/api/v1/realestate/1
```

last number say which ID to delete.
if you want to update any ID (realestate) Select PUT method and use this link 

```
http://localhost:8080/api/v1/realestate/1
```

> 1 - id which you will want to edit

and in params you can say key is city and value is test and send request it should work.
to post new data choose method POST and go to body, choose raw and JSON
before sending it should contain all of these because there is no default value because all value is needed.
swagger documentation: 

```
http://localhost:8080/v2/api-docs
```
