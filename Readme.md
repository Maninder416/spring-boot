## How to enable ssl security in spring boot app

```shell
1. In this application, we are implementing CRUD operation using h2 db.
2. No need to define any h2 configuration in application.yml.
3. Also enabled ssl certificate.

```

## With the help of query we are generating the self certificate.
```shell
keytool -genkey -alias https-example -storetype JKS -keyalg RSA -key
size 2048 -validity 365 -keystore http-example.jks

-genkey: generate key
alias : name
validity: 365 days
size of certificate

```
![Alt Text](images/img.png)