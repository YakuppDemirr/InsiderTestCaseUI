pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                script {
                    // Maven komutlarını çalıştır
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
