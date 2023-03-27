```bash

How to install jenkins on local machine:
1. We need to pick the image from docker hub.
2. Run the below-mentioned command:
docker run -p 8080:8080 -p 50000:50000 -d -v 
jenkins_home:/var/jenkins_home jenkins/jenkins:latest

3.8080 is the default port for jenkins
4. 50000 is the port for master slave to connect with each other

5. After running it, container will up. check it using docker container ls
6. Check the container logs, using "docker logs containerId"
7. It will give you password. Copy this password and hit the
http://localhost:8080 url and enter the password here.
8. Click on suggested plugins and give your normal information.

In-case of any issues, watch this video for your reference:

https://www.youtube.com/watch?v=pMO26j2OUME&ab_channel=TechWorldwithNana


```