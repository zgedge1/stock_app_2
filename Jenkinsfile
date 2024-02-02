pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Find Maven home dynamically
                    def mavenHome = sh(script: 'mvn -v | grep "Maven home"', returnStdout: true).trim().replaceAll('Maven home: ', '')

                    // Use Maven home to run Maven commands
                    sh "${mavenHome}/bin/mvn clean install"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Find Maven home dynamically
                    def mavenHome = sh(script: 'mvn -v | grep "Maven home"', returnStdout: true).trim().replaceAll('Maven home: ', '')

                    // Use Maven home to run Maven test command
                    sh "${mavenHome}/bin/mvn test"
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    // Find Maven home dynamically
                    def mavenHome = sh(script: 'mvn -v | grep "Maven home"', returnStdout: true).trim().replaceAll('Maven home: ', '')

                    // Use Maven home to run Maven exec command
                    sh "${mavenHome}/bin/mvn exec:java -Dexec.mainClass=com.stockapp1.stock_app_non_gui"
                }
            }
        }

        stage('Debug') {
            steps {
                script {
                    // Find Maven home dynamically
                    def mavenHome = sh(script: 'mvn -v | grep "Maven home"', returnStdout: true).trim().replaceAll('Maven home: ', '')

                    // Output Maven-related information
                    sh "echo 'Maven Home: ${mavenHome}'"
                    sh "${mavenHome}/bin/mvn -version"
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline Build Success'
        }

        failure {
            echo 'Pipeline Build Failure'
        }
    }
}
