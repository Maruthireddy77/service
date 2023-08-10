FROM openjdk:11
EXPOSE 8080
ADD target/stockapp.jar stockapp.jar
ENTRYPOINT [ "java","-jar","/stockapp.jar" ]