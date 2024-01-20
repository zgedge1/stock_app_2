pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'jenkins/jenkins'
        LOCAL_CODE_PATH = '/home/zach/Documents/javacode/stock/src/main/java/com/stockapp1/stockappnogui.java'
        JAR_LIBRARY_NAME = 'stock-1.0-SNAPSHOT.jar'
        MAIN_CLASS = 'com.stockapp1.stockappnogui'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }

        stage('Build and Run in Docker') {
            steps {
                script {
                    // Build Docker command
                    def dockerCommand = "docker run -v ${LOCAL_CODE_PATH}:/app ${DOCKER_IMAGE} java -cp /app:/app/${JAR_LIBRARY_NAME} ${MAIN_CLASS}"

                    // Execute Docker command
                    sh dockerCommand
                }
            }
        }
    }
}
