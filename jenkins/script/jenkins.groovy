pipeline {
    agent any
    triggers {
        githubPush()
        githubPullRequest()
    }
    stages {
        stage('Build') {
            steps {
                echo "Building the project..."
                sh "mvn clean install"
            }
        }
        stage('Test') {
            steps {
                echo "Running tests..."
                sh "mvn test"
            }
        }
    }
}
