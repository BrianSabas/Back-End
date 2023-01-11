#FROM amazoncorretto:11-alpine-jdk
FROM amazoncorretto:19

LABEL MAINTEINER="emaaristimuno"

COPY ./target/api-porfolio-brian-1.0.0.jar api-porfolio-brian-1.0.0.jar

ENTRYPOINT ["java","-jar","/api-porfolio-brian-1.0.0.jar"]

EXPOSE 8080
