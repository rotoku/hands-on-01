FROM alpine/java:21-jdk

USER root

RUN addgroup -S spring && \
    adduser -S spring -G spring && \
    mkdir  /logs && \
    chown spring:spring /logs

USER spring:spring

COPY target/*SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]