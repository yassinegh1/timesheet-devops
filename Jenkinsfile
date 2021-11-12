pipeline {
    environment {
registry = "aymenghorbel/timesheet123"
registryCredential = 'dockerHub'
dockerImage = '' }
    agent any
stages {
stage("Cloning Project from Git") {
steps { 
git branch: 'ayme', credentialsId: 'GitCredentials', url: 'https://github.com/Achraf429/timesheet-devops.git'
}}
stage("Build") {
steps {
bat "mvn compile"}
}
stage("Unit tests") {
steps {
bat "mvn test"}
}

stage("Quality") {
steps {
bat "mvn sonar:sonar"}
}

stage("Clean- Package"){
steps {
bat "mvn clean package"}
}

stage("Nexus") {
steps {
bat "mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war -DskipTests"
}
}

stage('Build image with Docker') {
steps {
script {
   dockerImage = docker.build registry}}}
stage('Push image with Docker') {
steps {
script {
docker.withRegistry( '', registryCredential ) {
   dockerImage.push()}}}}
}
  
    post {
        success {
    emailext attachLog: true, body: '''End of Pipeline
Finished: SUCCESS''', subject: '#Success', to: 'aymen.ghorbel125@gmail.com'}
    failure  {
    emailext attachLog: true, body: '''End of Pipeline
Finished: FAILURE''', subject: '#Failure', to: 'aymen.ghorbel125@gmail.com'}
    } 
    
}
