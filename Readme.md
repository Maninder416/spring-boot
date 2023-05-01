### Spring boot app with security


### Topics covered in this spring boot app:
```shell
1. Docker mysql running local spring boot app.
2. CRUD operation
3. Slueth
4. Zipkin Server
```

### How to run spring boot app:
```shell
1. Need to run docker-compose file first as we are using docker mysql
2. Run the spring boot app.
```

### Basic introduction
```shell
In the microservices world, a user action on UI may invoke one microservice API endpoint, which in turn
invoke another microservice endpoint. For example, when a user sees the catalog, shoppingcart-ui will invoke
catalog-service REST API http://localhost:8181/api/products which in turn calls inventory-service REST
API http://localhost:8282/api/inventory to check for inventory availability.

Suppose, an exception has occurred or the data returned is invalid and you want to investigate what
 is wrong by looking at logs. But as of now, there is no way to correlate the logs of that particular user 
 across multiple services
 
One solution to this is at the beginning of the call chain we can create a CORRELATION_ID and add it to all
log statements. Along with it, send CORRELATION_ID as a header to all the downstream services as well so that
those downstream services also use CORRELATION_ID in logs. This way we can identify all the log statements
related to a particular action across services. 

We can implement this solution using MDC feature of Logging frameworks. Typically we will have a WebRequest 
Interceptor where you can check whether there is a CORRELATION_ID header. If there is no CORRELATION_ID in 
the header then create a new one and set it in MDC. The logging frameworks include the information set in MDC
with all log statements.

But, instead of we doing all this work we can use Spring Cloud Sleuth which will do all this and much more
 for us
 
In addition to that, we can also export this information to Zipkin so that we can visualize this through UI. 
```

### Steps to do it:
```shell
1. Add the pom dependencies.
2. Enabled the logging for sleuth. Somehow it was not showing logs for sleuth
so just enabled it from applicaiton.yml.
3. Now start the zipkin server for sending the request to zipkin server.
4. Using below mentioned command, our zipkin server will start at local:
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

http://127.0.0.1:9411/zipkin/traces/644ff8923a17b9665cdeaf2cf718f39e

5. When you have only one microservice, in this case your span id and trace id will be same.
INFO  [644ffad9237fd44b0457fbaacf6ece70,0457fbaacf6ece70]

6. Hit the endpoints and trace it into the zipkin server.

```

































