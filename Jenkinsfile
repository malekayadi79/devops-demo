pipeline {
    agent any

    tools {
        maven 'M2_HOME'
    }

    environment {
        IMAGE = "malekayadi79/devops-demo"
        TAG   = "${env.BUILD_NUMBER}"
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }

        stage('Build & Unit tests') {
            steps { sh 'mvn -B clean verify' }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Docker build') {
            steps { sh 'docker build -t $IMAGE:$TAG -t $IMAGE:latest .' }
        }

        stage('Trivy scan') {
            steps {
                sh '''
                  docker run --rm -v /var/run/docker.sock:/var/run/docker.sock \
                    aquasec/trivy:0.57.1 image --severity HIGH,CRITICAL \
                    --ignore-unfixed --exit-code 1 $IMAGE:$TAG
                '''
            }
        }

        stage('Smoke test') {
            steps { sh 'docker run --rm $IMAGE:$TAG | grep "Hello DevOps CI!"' }
        }
    }

    post {
        success { echo "Build ${TAG} OK" }
        failure { echo "Build ${TAG} failed — check the stage logs" }
    }
}
