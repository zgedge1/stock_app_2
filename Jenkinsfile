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
            }
        }

        stage ('Build'){
            steps{
                script{

                    env.JAVA_HOME = tool('JDK11')
                    def mavenCMD = tool 'maven1'
                    sh "${mavenCMD} clean compile"
                }
            }
        }

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
