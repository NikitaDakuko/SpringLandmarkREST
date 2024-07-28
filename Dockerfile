FROM amazoncorretto:17

ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} application.war
CMD apt-get update -y
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.war"]