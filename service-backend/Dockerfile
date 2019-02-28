#FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
#FROM registry.access.redhat.com/rhel7.3
FROM tomcat

MAINTAINER Shankar Govindarajan <shgovind@redhat.com>
LABEL description="This is a sample rest app"

EXPOSE 8080 8443 28443

RUN mkdir -p ./var/conf
RUN chmod -R 777 ./var/conf/

#COPY ./target/service-backend.jar app.jar
COPY ./target/service-backend.war /usr/local/tomcat/webapps/service-backend.war
COPY ./keystore.p12 ./var/conf/keystore.p12
COPY ./server.xml /usr/local/tomcat/conf/server.xml

RUN chmod -R 777 /usr/local/tomcat/webapps/
RUN chmod -R 777 /usr/local/tomcat/webapps/service-backend.war

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
