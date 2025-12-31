# Base Jenkins LTS image
FROM jenkins/jenkins:lts

# Switch to root to install packages
USER root

# Install Maven & Git
RUN apt-get update && \
    apt-get install -y maven git && \
    apt-get clean

# Switch back to Jenkins user
USER jenkins
