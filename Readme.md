

## How to run app?

```shell
$ git clone https://github.com/Maninder416/spring-boot.git
$ cd spring-boot
$ ./run.sh start
$ ./run.sh stop

```
* To start only dependent services

```shell
$ ./run.sh start_infra
$ ./run.sh stop_infra

```

```shell
## Steps to reproduce the issue:
1. docker image is present on docker hub once my project pipeline successfully completed:
maninder40407/bookmarker-api-jib:latest

2. Kind cluster is up and working:

3. Running this command as explained by you:

kubectl run bookmarker-api --image=maninder40407/bookmarker-api-lib --port=8080
or
kubectl run bookmarker-api --image=maninder40407/bookmarker-api-lib:latest --port=8080

4. Able to create the pod but, it is not in running status

5. If I run the below-mentioned command to create pod, it worked fine:
   kubectl apply -f pod.yml
```












```