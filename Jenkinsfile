
pipeline {
    agent {
        docker {
            image 'maven:latest' // Use a Maven image with Java pre-installed
            args '-v $PWD:/workspace' // Mount the current directory to /workspace in the container
        }
    }

    stages {
        stage('Test') {
            steps {
                script {
                    // Change to the workspace directory
                    dir('/workspace') {
                        // List files to check the directory structure
                        sh 'ls -R'

                        // Compile Java code
                        sh 'javac -d target /home/workspace/stock_app_no_gui_java/src/main/java/com/stockapp1'

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
