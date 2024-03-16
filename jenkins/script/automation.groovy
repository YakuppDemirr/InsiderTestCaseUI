pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                git 'https://github.com/kullanici/adres'
            }
        }
        stage('Build and test') {
            steps {
                sh 'mvn clean test' // Bu Maven ile testleri çalıştırdığınızı varsayalım
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
