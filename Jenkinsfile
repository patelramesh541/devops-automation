pipeline {
    agent any
     environment {
        max = 50
        random_num = "${Math.abs(new Random().nextInt(max+1))}"
    }
    tools{
        maven 'maven396'
    }
    stages{

        stage('Build Maven'){
            steps{
               checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/patelramesh541/devops-automation']])

                bat 'mvn clean install'
            }
        }
         stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t rameshlpatel/devops-integration .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   bat 'docker login -u rameshlpatel -p Hetika1234$'
                   bat 'docker push rameshlpatel/devops-integration'
                }
            }
        }
        stage('Azure container deploy '){
            steps{
                withCredentials([azureServicePrincipal('ad1cbdba-8f60-4f60-b1fb-16eed9e9c470')]) {
                     bat 'az login --service-principal -u %AZURE_CLIENT_ID% -p %AZURE_CLIENT_SECRET% -t %AZURE_TENANT_ID%'
                     bat 'az container create --resource-group devops-automation --name mycontainer --image registry.hub.docker.com/rameshlpatel/devops-integration:latest --dns-name-label ramesh-te --ports 8080'
}
            }
        }

    }

}
