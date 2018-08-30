FROM openjdk:8-jdk-alpine

ADD ./target/*.jar app.jar

RUN mkdir .kube
ADD .kube .kube/

ADD helm /usr/local/bin/helm

RUN chmod +x /usr/local/bin/helm

RUN mkdir helm-minecraft
ADD helm-minecraft helm-minecraft/

ADD createdeploy.sh .
RUN chmod +x createdeploy.sh

EXPOSE 8080

ENV KUBECONFIG .kube/config

ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/app.jar"]

