FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean install


FROM bellsoft/liberica-openjre-alpine

COPY --from=build /app/target/github-search.jar /app.jar

EXPOSE 7777
CMD ["java", "-jar", "/app.jar"]
