pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Maven'ı çalıştırmak için bat dosyasını çağır
                dir ('C:/ProgramData/Jenkins/.jenkins/workspace/InsiderTestCaseUIPipeline')
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Maven'ı testleri çalıştırmak için çağır
                bat 'mvn test'
            }
        }
    }
}
