
pipeline{
    agent any

    tools{
        maven 'maven1'
        jdk 'JDK11'
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
                    sh"${mavenCmd} clean install"
                    echo '$PATH'
                    sh'which mvn'
                    sh "ls-l ${mavenCmd}"
                }
            }
        }

        stage ('test'){
            steps{
                script{
                    def mavenCmd = tool 'maven1'
                    sh "${mavenCmd} test"
                }
            }
        }

        stage ('Install Dependencies'){
            steps{
                script{
                    def mavenCmd = tool 'maven1'
                    sh "${mavenCmd} exec: java -Dexec.mainClass=com.stockapp1.stock_app_non_gui"
                }
            }
        }

        stage ('Debug'){
            steps{
                script{
                    sh 'echo $PATH'
                    sh 'which mvn'
                    sh 'ls-l/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven1'
                    sh 'ls -l /var/jenkins_home/workspace/stock_app_non_gui'
                    sh 'ls -l /var/jenkins_home/workspace/stock_app_non_gui'
                }
            }
        }
    }

    post{
        success{
            echo 'Pipeline Build Success'
        }

        failure{
            echo 'Pipeline Build Failure'
        }
    }
}