pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Maven'ı çalıştırmak için bat dosyasını çağır
                dir ('C:/Users/Yakup Demir/Desktop/InsiderTest') {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                // Maven'ı testleri çalıştırmak için çağır
                dir ('C:/Users/Yakup Demir/Desktop/InsiderTest') {
                    sh 'mvn test'
                }
            }
        }
    }
}