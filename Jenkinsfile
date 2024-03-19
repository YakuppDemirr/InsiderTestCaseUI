pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    'mvn test'
                }
            }
        }
    }
}