pipeline {
    agent any
    tools {
        maven 'maven_3_8_7'
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

    }
}
