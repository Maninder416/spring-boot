pipeline {
    agent any
    tools {
            maven 'Maven 3.9.1'
            jdk 'jdk11'
    }
    stages {
        stage('Build Create and Push Image') {
            steps {
            withCredentials([usernamePassword(credentialsId: 'fd66cf7b-17f4-443b-b7f2-4a39e236dcfe', passwordVariable: 'p', usernameVariable: 'u')]) {
                sh 'mvn clean install -Ddocker.username=$u -Ddocker.password=$p'
            }

            }
        }

    }
}