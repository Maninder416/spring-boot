### Spring security without WebSecurityConfigureAdapter Class

```shell
1. Below is the code with latest spring security changes:
2. Saving the password in encrypted form while saving the user.
3. "/user", for creating the new user which has roles assigned.
```
![Alt Text](images/img.png)

**User Entity**
![Alt Text](images/img_1.png)

**User Repository**
![Alt Text](images/img_2.png)

**UserDetails Implementation**
![Alt Text](images/img_3.png)

**UserDetails Service implementation**
![Alt Text](images/img_4.png)

**User Controller**
![Alt Text](images/img_5.png)

**Book Controller**
![Alt Text](images/img_6.png)


**User creation:**
```shell

http://localhost:9001/user
{
    "username": "maninder",
    "password": "maninder",
    "roles": "ROLE_ADMIN",
    "enabled": true
}

```