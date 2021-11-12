pipeline{

	environment{
		registry = 'achraf14/devopsimage'
		registryCredential= 'dockerHub'
		dockerImage = ''
	}


		agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'achrafAyari',
					url : 'https://github.com/Achraf429/timesheet-devops.git';
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
		 		bat """mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war"""
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
			mail bcc: '', body: 'build_success', cc: '', from: '', replyTo: '', subject: 'jenkins', to: 'ayari.achraf55555@gmail.com'
			}
		}
	}


	
}
