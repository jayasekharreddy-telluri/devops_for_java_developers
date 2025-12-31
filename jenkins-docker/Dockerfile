# Base Jenkins LTS image with OpenJDK 17
FROM jenkins/jenkins:lts-jdk17

# Switch to root to install tools
USER root

# Install Maven, Docker CLI, AWS CLI, kubectl
RUN apt-get update && apt-get install -y \
    maven \
    docker.io \
    curl \
    unzip \
    && curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" \
    && install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl \
    && curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" \
    && unzip awscliv2.zip \
    && ./aws/install \
    && rm -rf aws awscliv2.zip \
    && apt-get clean

# Switch back to Jenkins user
USER jenkins
