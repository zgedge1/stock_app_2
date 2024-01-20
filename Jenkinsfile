pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout your code from version control (e.g., Git)
                    checkout scm
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Compile the Java code
                    sh 'javac -cp .:/home/zach/Documents/javacode/stock/target/stock-1.0-SNAPSHOT.jar /var/jenkins_home/workspace/stock_app_no_gui_java/src/main/java/com/stockapp1'
                }
            }
        }

        stage('Run') {
            steps {
                script {
                    // Run the Java application
                    sh 'java -cp .:/home/zach/Documents/javacode/stock/target/stock-1.0-SNAPSHOT.jar /var/jenkins_home/workspace/stock_app_no_gui_java/src/main/java/com/stockapp1'
/stockapp1''
                }
            }
        }
    }
}
