pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bash 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bash 'mvn test'
            }
        }
    }
}
