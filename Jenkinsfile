pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                script {
                    // Run Docker commands inside a script block
                    sh 'docker run -v $PWD:/workspace -w /workspace maven:latest ls -R'

                    // Compile Java code
                    sh 'docker run -v $PWD:/workspace -w /workspace maven:latest mvn clean compile'

                    // Run the compiled Java class
                    sh 'docker run -v $PWD:/workspace -w /workspace maven:latest java -cp target com.stockapp1.stockappgui'
                }
            }
        }
        // Other stages...
    }

    // Post actions...
}
