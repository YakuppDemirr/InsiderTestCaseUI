pipeline {
    agent any
    
    triggers {
        github {
            events: [push, pull_request]
            branches: ['main']
        }
    }
    
    stages {
        stage('Build') {
            steps {
                script {
                    // Maven projesinin bulunduğu dizine git
                    dir('/Users/yakup.demir/Desktop/InsiderTestCasesUI-main') {
                        // Maven komutunu çalıştır: temizle ve yükle
                        sh 'mvn clean install'
                    }
                }
            }
        }
        
        stage('Test') {
            steps {
                script {
                    // Maven projesinin bulunduğu dizine git
                    dir('/Users/yakup.demir/Desktop/InsiderTestCasesUI-main') {
                        // Maven komutunu çalıştır: test et
                        sh 'mvn test'
                    }
                }
            }
        }
    }
}
