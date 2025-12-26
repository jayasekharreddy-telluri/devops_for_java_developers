pipeline {
    agent any

    environment {
        IMAGE_NAME = "product-service"
        K8S_YAML = "kubernetes-microservices-ymls/product-service.yml"

        // Minikube Docker environment
        DOCKER_HOST = "tcp://192.168.49.2:2376"
        DOCKER_TLS_VERIFY = "1"
        DOCKER_CERT_PATH = "/root/.minikube/certs"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/jayasekharreddy-telluri/devops_for_java_developers.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                dir('product-service') {
                    echo "Building product-service..."
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('product-service') {
                    echo "Building Docker image on Minikube..."
                    sh "docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} ."
                }
            }
        }

        stage('Deploy to Minikube') {
            steps {
                echo "Deploying product-service to Minikube..."
                sh """
                kubectl apply -f ${K8S_YAML}
                kubectl set image deployment/${IMAGE_NAME} ${IMAGE_NAME}=${IMAGE_NAME}:${BUILD_NUMBER} --record
                """
            }
        }
    }

    post {
        success {
            echo "product-service deployed successfully!"
        }
        failure {
            echo "Pipeline failed for product-service. Check logs!"
        }
    }
}
