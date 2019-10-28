FROM openjdk:8
ADD target/moviesearch.jar moviesearch.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","moviesearch.jar"]