FROM gradle:jdk17 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:17-jdk-slim
COPY --from=gradleimage /home/gradle/source/build/libs/study-fc3-ci-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "study-fc3-ci-0.0.1-SNAPSHOT.jar"]