pipeline {
    agent any
    
    parameters {
        githubPushTrigger(enabled: true)
        githubPullRequestTrigger(enabled: true, triggerPhrase: 'run tests')
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
