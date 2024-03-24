pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    bat'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    bat 'mvn test'
                }
            }
        }
    }
}
