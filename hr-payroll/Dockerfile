FROM openjdk:11-jre-slim

VOLUME /tmp

COPY target/*.jar /hr-payroll.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

CMD ["java","-jar","/hr-payroll.jar"]
