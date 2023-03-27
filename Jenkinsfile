pipeline {
    agent any
    tools {
            maven 'maven-test'
    }
    stages {
        stage('Build Create and Push Image') {
            steps {
            withCredentials([usernamePassword(credentialsId: 'fd66cf7b-17f4-443b-b7f2-4a39e236dcfe', passwordVariable: 'p', usernameVariable: 'u')]) {
                sh 'mvn clean install -DskipTests -Ddocker.username=$u -Ddocker.password=$p'
            }

            }
        }

 		stage('Test'){
 			steps{
 				sh "mvn test"
 			}
 		}



    }
}