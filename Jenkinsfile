pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                bash 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                bash 'mvn test'
            }
        }
    }
}
