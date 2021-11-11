pipeline {
    environment {
registry = "230619981123/timesheet123"
registryCredential = 'dockerHub'
dockerImage = '' }
    agent any
stages {
stage("Cloning Project from Git") {
steps { 
git branch: 'main', credentialsId: 'GitCredentials', url: 'https://github.com/houdafarh/DEVOPS.git'
}
}
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
bat "mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=2.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-2.0.war -DskipTests"
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
    } 
  
} 
