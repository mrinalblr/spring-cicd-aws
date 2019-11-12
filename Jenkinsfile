pipeline {
  agent any
       environment{
           dockerHubRegistry = 'mrdeo/spring-cicd'
           dockerImage = ''

          }
     stages {
        stage('Init'){
           steps{
              echo 'Initializing the pipeline'
           }
        }
        stage('Checkout SCM'){
            steps{
                echo 'Checking out the SCM for latest Codebase'
                git 'https://github.com/mrinalblr/spring-cicd-aws.git'
            }
        }
        stage('Build Jar'){
             steps{
                echo 'Building the jar..'
                sh 'mvn -version'
                sh 'mvn clean package '
             }
        }
       
     }

  }
