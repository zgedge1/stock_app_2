pipeline {
    agent any

    stages {
        stage('SCM') {
            steps {
                checkout scm
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarScanner'

                    withSonarQubeEnv(sonar_scanner_1) {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'SonarQube Analysis completed successfully'
        }
        failure {
            echo 'SonarQube Analysis failed'
        }
    }
}
