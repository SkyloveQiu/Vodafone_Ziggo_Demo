# VodafoneZiggo Task1

## Requirements

For building and running the application you need:

- [JDK 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
- [Gradle 7.8](https://gradle.org/releases/)


## Run this application locally
To run this application locally, you need to use terminal and type
```
./gradlew run
```

## Run this application in docker(Recommended)
To run this application in docker, you need to use terminal and type
```
 ./gradlew build
  docker build --build-arg JAR_FILE=build/libs/*.jar -t vodafoneziggo/demo .
   docker run -p 8088:8088 vodafoneziggo/demo
```

Then this application will be run on the port `8088`.

## Swagger Docs
You can view the swagger documentation on [Swagger](http://localhost:8088/swagger-ui/index.html).

