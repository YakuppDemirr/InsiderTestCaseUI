pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                dir ('C:/Users/Yakup Demir/Desktop/InsiderTest') {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                dir ('C:/Users/Yakup Demir/Desktop/InsiderTest') {
                    bat 'mvn test'
                }
            }
        }
    }
}
