pipeline {
    agent any

    tools {
        maven 'maven1'
        jdk 'https://download.oracle.com/otn/java/jdk/11.0.21%2B9/8819d0447e4d41b3bd1d9e1007728d17/jdk-11.0.21_linux-x64_bin.tar.gz'
    }

    stages{

        stage('Checkout Code'){
            steps{
                checkout scm
            }
        }

        stage('Build'){
            steps{
                script{
                    def mavenCmd = tool 'maven1'
                    def projectPath = "/var/jenkins_home/workspace/stock_app_non_gui"
                    sh "${mavenCmd} clean compile"
                    sh 'echo $PATH'
                    sh 'which mvn'
                    sh "ls -l ${mavenCmd}"
                }
            }
        }

        stage('Test'){
            steps{
                script{
                    def mavenCmd = tool 'maven1'
                    sh "${mavenCmd} test"
                }
            } 
        }

        stage('Install Dependencies') {
            steps{
                script {
                    def mavenCmd = tool 'maven1'
                    sh "${mavenCmd} install"
                }
            }
        }

        stage ('Run Application') {
            steps{
                script{
                    def mavenCmd = tool 'maven1'
                    sh "${mavenCmd} exec:java -Dexec.mainClass=com.stockapp1.stockappgui"
                }
            }
        }

        stage ('Debug') {
            steps{
                script{
                    sh 'echo $PATH'
                    sh 'which mvn'
                    sh 'ls -l /var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven1'
                    sh 'ls -l /var/jenkins_home/workspace/stock_app_non_gui'
                    sh 'ls -l /var/jenkins_home/workspace/stock_app_non_gui'

                }
            }
        }
    }

    post{
        success{
            echo 'Pipeline Build Success!'
        }

        failure{
            echo 'Pipeline Failed!'
        }
    }
}