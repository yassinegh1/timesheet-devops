FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
EXPOSE 8089
ADD target/*.war Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war
ENTRYPOINT ["java","-war","/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war"]