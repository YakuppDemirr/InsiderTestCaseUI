pipeline {
    agent any
    triggers {
        github {
            events = ['push', 'pull_request']
            branches = 'main'
        }
    }
    stages {
        stage('Build') {
            steps {
                script {
                    mvn 'clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    mvn 'test'
                }
            }
        }
    }
}
