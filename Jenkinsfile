pipeline {
  agent any
       environment{
           dockerHubRegistry = 'mrdeo/spring-cicd-aws'
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
        stage('Build Jar'){
             steps{
                echo 'Building the jar..'
                sh 'mvn -version'
                sh 'mvn clean package '
             }
        }
         stage('Remove unused images'){
             steps{
                 echo 'Cleaning up the volume by removing unused and unwanted docker images..'
                 sh 'docker system prune -a'
             }

         }
        stage('Building Image'){
                        steps{
                            echo 'Building the docker image'
                            script{
                                dockerImage = docker.build dockerHubRegistry + ":latest"
                             }

                        }
         }
         stage('Publishing to Docker Hub'){
                        steps{
                            echo 'Publishing the image to docker hub'
                            script{
                                docker.withRegistry('',dockerHubCredentials){
                                    dockerImage.push()
                                }

                            }
                        }
         }
         stage('Deploying the image'){
                        steps{
                            echo 'Deploying the docker image'
                            echo "${dockerImage}"
                            sh "docker run -d -p 8083:8082 --name spring-cicd-aws mrdeo/spring-cicd-aws:latest"
                            echo 'Successfully deployed'
                            echo 'http://13.233.131.249:8083/api/healthcheck'
                        }
         }


     }

  }
