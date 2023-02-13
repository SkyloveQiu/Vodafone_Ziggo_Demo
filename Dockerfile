FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} VodafoneZiggo_Demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/VodafoneZiggo_Demo-0.0.1-SNAPSHOT.jar"]