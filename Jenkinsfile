pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                script {
                    // Maven projesinin bulunduğu dizine git
                    dir('https://github.com/YakuppDemirr/InsiderTestCaseUI.git') {
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
                    dir('https://github.com/YakuppDemirr/InsiderTestCaseUI.git') {
                        // Maven komutunu çalıştır: test et
                        sh 'mvn test'
                    }
                }
            }
        }
    }
}
