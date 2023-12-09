FROM openjdk:17-jdk-slim
RUN mkdir -p /usr/local/cloud-service
ADD build/libs/cloud-service.jar /usr/local/cloud-service/
EXPOSE 8000
ENTRYPOINT ["java", \
           "-Djava.security.egd=file:/dev/./urandom", \
           "-Dserver.port=8000", \
           "-jar", \
           "/usr/local/cloud-service/cloud-service.jar"]