pipeline {
    agent any
    triggers {
        github {
            events('push', 'pull_request')
            branches('main')
        }
    }
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
    }
}
