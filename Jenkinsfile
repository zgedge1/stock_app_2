pipeline {
    agent any

    tools{
        maven 'maven1'
        jdk 'JDK11'
    }

    stages {
        stage('SCM') {
            steps {
                checkout scm
            }}

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'sonar_scanner_1'
                    withSonarQubeEnv() {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }
}
