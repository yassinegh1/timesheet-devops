pipeline{

	environment{
		registry = 'yassine01/devops'
		registryCredential= 'dockerHub'
		dockerImage = ''
	}


		agent any 
	stages{
		stage ('ChECKOUt GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'yassine',
					url : 'https://github.com/yassinegh1/timesheet-devops';
			}
		}

		stage ("Verification du  version Maven"){
			steps{
				bat """mvn -version"""
			}
		}



		 stage ("clean"){
		 	steps{
		 		bat """mvn clean """
		 	}
		 }


 		 stage ("creation de livrable"){
		 	steps{
		 		bat """mvn package -Dmaven.test.skip=true"""
		 	}
		 }

		 stage ("Lancement des Tests Unitaires"){
		 	steps{
		 		bat """mvn test"""
		 	}
		 }


		 stage ("Analyse avec Sonar"){
		 	steps{
		 		bat """mvn sonar:sonar"""
		 	}
		 }

		 stage ("Deploiement "){
		 	steps{
		 		bat """mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=0.0.1 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1.war"""
		 	}
		 }
		 stage('Building our image'){
			steps{ 
				script{ 
					dockerImage= docker.build registry + ":$BUILD_NUMBER" 
				}
			}
		}

		stage('Deploy our image'){
			steps{ 
				script{
					docker.withRegistry( '', registryCredential){
						dockerImage.push()
					} 
				} 
			}
		}

		stage('Cleaning up'){
			steps{
				bat "docker rmi $registry:$BUILD_NUMBER" 
			}
		}
		stage('email'){
			steps{
			mail bcc: '', body: 'build_success', cc: '', from: '', replyTo: '', subject: 'jenkins', to: 'yassinegh484@gmail.com'
			}
		}
	}


	
}
