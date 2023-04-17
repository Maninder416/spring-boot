### Spring boot app with security

### Topics covered in this spring boot app:
```shell
1. Docker mysql running local spring boot app.
2. Added spring security for CRUD operation and assign admin and
default users.
```

### How to run spring boot app:
```shell
1. Need to run docker-compose file first as we are using docker mysql
2. Run the spring boot app.
3. In this application, we have covered 2 scenarios in which we
save users in memory and also in DB.

create user script:

create table user(
id int,
user_name varchar(50),
password varchar(50),
roles varchar(50),
active boolean );

insert statement:

insert into user values (1, true, 'admin','ADMIN','admin');
insert into user values (2, true, 'user','USER','user');

you can access the application on:
http://localhost:9001/books


```