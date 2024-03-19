pipeline {
    agent any
    triggers {
        githubPush(branch: 'main')
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
        stage('Deploy') {
            steps {
                echo "Deploying the project..."
                // Add deployment steps here
            }
        }
    }
}
