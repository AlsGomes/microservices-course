FROM openjdk:11-jre-slim

VOLUME /tmp

EXPOSE 8761

COPY target/*.jar /hr-eureka-server.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

CMD ["java","-jar","/hr-eureka-server.jar"]
