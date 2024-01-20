pipeline {
    agent any

    tools {
        jdk 'JDK11'
    }

    stages {
        stage('Test') {
            steps {
                script {
                    // Compile Java code
                    sh 'javac -d target src/main/java/com/stockapp1/stockappgui.java'

                    // Run the compiled Java class
                    sh 'java -cp target com.stockapp1.stockappgui'
                }
            }
        }
        // Other stages...
    }

    // Post actions...
}
