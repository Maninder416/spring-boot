### Spring boot app with security


### Topics covered in this spring boot app:
```shell
1. Docker mysql running local spring boot app.
2. CRUD operation
3. Keycloak implementation
```
**Somehow our keycloak docker-compose is not working**

### Steps to run keycloak:
```shell
1. clone it: https://github.com/keycloak/keycloak-containers.git
2. cd keycloak-containers/server
3. docker build -t jboss/keycloak:13.0.1 .
4. docker run --rm -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak:13.0.1
5. try to access it: http://localhost:8080/auth/
6. user/pass: admin

```


### How to run spring boot app:
```shell
1. Need to run keycloak mentioned above and 
docker-compose file as we are using docker mysql
2. Run the spring boot app.
```