pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "3.9.4"
    }

    stages {
        stage('Build') {
            steps {
               git branch: 'rozetka', url: 'https://github.com/oshcherbina17/carina-demo.git'
                sh "mvn clean test -Dsuite=rozetka/web-rozetka"
            }

        }
        stage('Run') {
            steps {
               git branch: 'cucumber', url: 'https://github.com/oshcherbina17/carina-demo.git'
                sh "mvn clean test -Dsuite=rozetka/cucumber-rozetka"
            }
        }
    }
}
