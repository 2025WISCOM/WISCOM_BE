FROM openjdk:20-jdk

ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY build/libs/*.jar app.jar
COPY src/main/resources/application.yml src/main/resources/application.yml

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]