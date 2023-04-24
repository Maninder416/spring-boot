### spring app running on container to run integration test cases


```shell
If our spring boot app is running with docker-compose mysql,
in that case we run the docker mysql first and then run our integration
test cases, but in spring 3.1.0, they have implemented the functionality
of containers. 

you just need to mention the container name and on the behalf of
that you can run your spring boot integration test cases
without running the spring boot app.

Steps:
1. Added the required dependencies in POM.
2. Created one container class, in which we mention that we need these
containers.
3. Created the TestApplication, in which we mention that this is our
main class and also pass the reference of container class from which
it can pick the required container to run spring boot app.
4. Suppose, our spring boot app is running with mysql so it pick the 
container information from container class and used it in our spring boot
app.
5. Also added the logging for test cases.

video reference:
https://www.youtube.com/watch?v=UuLD9gZmiZU&ab_channel=SivaLabs

```