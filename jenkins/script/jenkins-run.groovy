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
        stage('Results') {
            steps {
                dir ('C:/Users/Yakup Demir/Desktop/InsiderTest') {
                    junit '**/target/surefire-reports/*.xml'
                    publishHTML(target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: '**/target/surefire-reports/*.html',
                            reportName: 'HTML Test Report'
                    ])
                }
            }
        }
    }
}
