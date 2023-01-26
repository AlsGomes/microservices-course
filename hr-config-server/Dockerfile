FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 8888
ADD ./target/*.jar hr-config-server.jar
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]
