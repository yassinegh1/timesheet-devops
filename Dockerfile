FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
EXPOSE 8080
ADD target/*.war Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1.war
ENTRYPOINT ["java","-war","/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1.war"