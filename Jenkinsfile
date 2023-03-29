pipeline {
    agent any
    tools {
            maven 'maven-test'
            'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker-test'
    }
    stages {
        stage('Build Create and Push Image') {
            steps {
            withCredentials([usernamePassword(credentialsId: '8b688f9b-c143-4bcf-9eb5-7c0a2edf2d70', passwordVariable: 'p', usernameVariable: 'u')]) {
                sh 'mvn clean install -DskipTests -Ddocker.username=$u -Ddocker.password=$p'
            }

            }
        }

 		stage('Run the docker image'){
 			steps{
 			withCredentials([usernamePassword(credentialsId: '8b688f9b-c143-4bcf-9eb5-7c0a2edf2d70', passwordVariable: 'p', usernameVariable: 'u')]) {
                            sh "docker build -t maninder40407/employee-jdbc ."
            }

 			}
 		}

        stage('Run the test cases'){
 			steps{
 			withCredentials([usernamePassword(credentialsId: '8b688f9b-c143-4bcf-9eb5-7c0a2edf2d70', passwordVariable: 'p', usernameVariable: 'u')]) {
                            sh "mvn test"
            }

 			}
 		}

    }
}