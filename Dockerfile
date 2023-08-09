FROM gradle:8.2.1-jdk17 AS build

WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build


FROM bellsoft/liberica-openjre-alpine

COPY --from=build app/build/libs/github-search-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7777
CMD ["java", "-jar", "app.jar"]