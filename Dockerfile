FROM eclipse-temurin:21
FROM maven

WORKDIR /app
ADD pom.xml /app
RUN mvn verify clean --fail-never

COPY . /app
RUN mvn -v
RUN mvn clean install
EXPOSE 8080
COPY ./target/*.war /app.war

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/app.war"]