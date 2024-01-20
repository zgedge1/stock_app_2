pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                script {
                    // Run commands inside a Docker container
                    docker.image('maven:latest').inside {
                        // Change to the workspace directory
                        sh 'cd /workspace'

                        // List files to check the directory structure
                        sh 'ls -R'

                        // Compile Java code
                        sh 'javac -d target src/main/java/com/stockapp1/stockappgui.java'

                        // Run the compiled Java class
                        sh 'java -cp target com.stockapp1.stockappgui'
                    }
                }
            }
        }
        // Other stages...
    }

    // Post actions...
}
