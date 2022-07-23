#!/usr/bin/env groovy

pipeline {

    agent any

    options { disableConcurrentBuilds() }


    stages {

         stage('Permissions') {
            steps {
                sh 'chmod 775 *'
            }
        }

        stage('Compile stage') {
            steps {
                sh "mvn clean compile"
            }
           }


        stage('install') {
             steps {
                sh "mvn install -Dmaven.test.skip=true -P prod"
                }
            }

        stage('Update Docker UAT image') {

            steps {
                sh '''
                    docker login -u "ouzss" -p "Samia@58623712"
                    docker build --no-cache -t crmproxy:latest .
                    docker tag crmproxy:latest ouzss/crmproxy:latest
                    docker push ouzss/crmproxy:latest
                    docker rmi crmproxy:latest
                '''
                    }
            }

        stage('Update UAT container') {

            steps {
                sh '''
                docker login -u "ouzss" -p "Samia@58623712"
                    docker pull ouzss/crmproxy:latest  
                    docker stop crmproxy  
                   docker rm crmproxy  
                    docker run -v /opt/logs:/logs -p 9012:9012 --name crmproxy --network dbconnexion  --restart=always -t -d ouzss/crmproxy:latest 

                '''
            }
        }

    }
  }