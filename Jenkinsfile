pipeline {
    agent any
    tools {
        maven 'maven_3_8_7'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
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
                sh 'docker build -t edi123/devopsjava .'
            }
        }
        stage('Login to docker hub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Push') {
            steps {
                sh 'docker push edi123/devopsjava'
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}
