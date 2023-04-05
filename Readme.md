

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

2. how to create the pod:
kubectl run bookmarker-api --image=maninder40407/bookmarker-api-jib --port=8080

3. If you want to see the configuration, while creating the pod using this command we can use:
kubectl run bookmarker-api2 --image=maninder40407/bookmarker-api-jib --port=8080 --dry-run=client -o yaml

it will print output like this:

*****************************************************
apiVersion: v1
kind: Pod
metadata:
  creationTimestamp: null
  labels:
    run: bookmarker-api2
  name: bookmarker-api2
spec:
  containers:
  - image: maninder40407/bookmarker-api-jib
    name: bookmarker-api2
    ports:
    - containerPort: 8080
    resources: {}
  dnsPolicy: ClusterFirst
  restartPolicy: Always
status: {}
***********************************************************

4. You can save this output into yml file like this:

kubectl run bookmarker-api2 --image=maninder40407/bookmarker-api-jib --port=8080 --dry-run=client -o yaml >
 pod.yml

and we can create pod from this yml file using command:
 
kubectl apply -f pod.yml

5. Delete pod:
kubectl delete -f pod.yml






```












```