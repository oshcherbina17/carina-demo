pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "3.9.4"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
               git branch: 'rozetka', url: 'https://github.com/oshcherbina17/carina-demo.git'
                // Run Maven on a Unix agent.
                sh "mvn clean test -Dsuite=rozetka/web-test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

        }
    }
}
