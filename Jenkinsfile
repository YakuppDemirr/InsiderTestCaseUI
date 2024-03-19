pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        skipDefaultCheckout() // Bu opsiyonel, eğer gerekliyse ekleyin.
    }
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
                     clean install
                }
            }
        }
        stage('Test') {
            steps {
                script {
                     mvn test
                }
            }
        }
    }
}
