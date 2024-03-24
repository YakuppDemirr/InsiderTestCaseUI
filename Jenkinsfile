pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Maven'ı çalıştırmak için bat dosyasını çağır
                echo 'Deneme - 1'
                dir ('C:/Users/Yakup Demir/Desktop/InsiderTest') {
                    echo 'Deneme - 2'
                    bat 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                // Maven'ı testleri çalıştırmak için çağır
                dir ('C:/Users/Yakup Demir/Desktop/InsiderTest') {
                    bat 'mvn test'
                }
            }
        }
    }
}
