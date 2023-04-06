

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

## kubernetes pod command:
```shell

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

## kubernetes deployment command:

```shell
1. create deployment:
kubectl create deployment bookmarker-api --image maninder40407/bookmarker-api-jib

When this command run, it will create pod, deployment, replica set for you.
you can check it using:
kubectl get all

2. delete deployment:
kubectl delete deployment.apps/bookmarker-api

3. create yml file from deployment command:
kubectl create deployment bookmarker-api --image maninder40407/bookmarker-api-jib --dry-run=client -o yaml > deployment.y
ml
o is output, means output type is yaml file.

4. scale up the replica set:
  a. go inside the yaml file and change the replica set count according to requirement:
  kubectl apply -f deployment.yml
  b. Another way to scale up the replica set:
  kubectl scale deployment bookmarker-api --replicas=3
  
```

## kubernetes configMap and secret command:

```shell
1. ConfigMap command:

kubectl create configmap db-config --from-literal=db_host=postgres --from-literal=db_name=appdb
providing db_host and db_name, as these are plain text so we need to store it in configmap

2. delete config map:
kubectl delete cm db-config


```












```