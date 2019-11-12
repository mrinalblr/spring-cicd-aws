pipeline {
  agent any
       environment{
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
     }

  }
