pipeline {
  agent any
       environment{
           mavenHome = tool name: '/usr/share/maven'
           mavenCMD = "${mavenHome}/bin/mvn"
           dockerHubRegistry = 'mrdeo/spring-cicd'
           dockerHubCredentials = 'dockerhubcred'
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
     }

  }
