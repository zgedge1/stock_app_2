# Example Dockerfile
FROM ubuntu:latest

# Install necessary packages
RUN apt-get update \
    && apt-get install -y maven \
    && rm -rf /var/lib/apt/lists/*

# Set the Maven home directory
ENV MAVEN_HOME /usr/share/maven

# Add Maven binaries to the PATH
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Set the working directory
WORKDIR /app

# Continue with other Dockerfile instructions...
