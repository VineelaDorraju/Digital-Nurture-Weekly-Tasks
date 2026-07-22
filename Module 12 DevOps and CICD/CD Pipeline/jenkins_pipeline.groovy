pipeline {
    agent any

    environment {
        APP_PORT = "5000"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-repo/devops-project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'javac App.java AppTest.java'
            }
        }

        stage('Run Application') {
            steps {
                sh '''
                nohup java App > app.log 2>&1 &
                sleep 3
                '''
            }
        }

        stage('Test') {
            steps {
                sh 'java AppTest'
            }
        }

        stage('Package') {
            steps {
                sh 'jar cfe app.jar App *.class'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                pkill -f "java -jar app.jar" || true
                nohup java -jar app.jar > deploy.log 2>&1 &
                '''
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '*.log', fingerprint: true
        }
        success {
            echo 'Pipeline executed successfully'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}