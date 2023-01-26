FROM openjdk:11-jre-slim

VOLUME /tmp

EXPOSE 8765

COPY target/*.jar /hr-api-gateway-zuul.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

CMD ["java","-jar","/hr-api-gateway-zuul.jar"]
