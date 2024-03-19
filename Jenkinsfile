pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Maven ile proje yapılandırması ve derleme
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Selenium testlerini çalıştır
                sh 'mvn test'
            }
        }
    }
}
