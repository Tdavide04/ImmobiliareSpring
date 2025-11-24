FROM amazoncorretto:21
COPY target/*.jar /app.jar
CMD java -Xmx512M -jar /app.jar
