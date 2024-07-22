# Kafka Avro Spring boot

### Avro dependency required to generate classes. <a name="quickstart-install_pre_commit_hook"></a>


![Base State Error](/images/img.png)
![Base State Error](/images/img_1.png)
![Base State Error](/images/img_2.png)
![Base State Error](/images/img_3.png)


### Command to check compatibility of schema <a name="quickstart-building_the_service"></a>

```sh
curl -X GET http://localhost:8081/subjects/
curl -X GET http://localhost:8081/config/javatechie-avro-value

```
### Command to change compatibility of schema <a name="quickstart-building_the_service"></a>

```sh
curl -X PUT -H "Content-Type:application/json" --data '{"compatibility": "BACKWARD"}' http://localhost:8081/config/javatechie-avro-value
```

```shell
compatibility can be one of the following values:
- NONE
- BACKWARD
- BACKWARD_TRANSITIVE
- FORWARD

```
