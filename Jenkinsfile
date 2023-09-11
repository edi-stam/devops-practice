pipeline {
    agent any
    tools {
        maven 'maven_3_8_7'
        docker 'docker'
    }
    stages {
        stage('Build Maven') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Create docker image') {
            steps {
                sh 'docker build -t devopsjava .'
            }
        }

    }
}
