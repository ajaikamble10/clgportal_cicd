FROM openjdk:17
EXPOSE 2020
ADD target/springboot-image-test.jar springboot-image-test.jar
ENTRYPOINT [ "java","-jar","/springboot-image-test.jar" ]