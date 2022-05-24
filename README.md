# GORM Data Services are not injected when deployed to Tomcat


## Steps to Deploy and Run Application with java 11

1. Build application using command `./gradlew build`.
2. Build Docker image using command `docker build -t gormdataservice:0.1 .`.
3. Start a new Docker container using command `docker run -it --rm -p 8080:8080 gormdataservice:0.1`.
4. Call http://localhost:8080/beer   return one register



## Steps to Deploy and Run Application with java 8 (1.8.0_242) and tomcat 9 (9.0.31)

1. Build application using command `./gradlew build`.
2. Build Docker image using command `docker build -f Dockerfile_java_8_tomcat9 -t gormdataservice8:0.1 .`.
3. Start a new Docker container using command `docker run -it --rm -p 8080:8080 gormdataservice8:0.1`.
4. Call http://localhost:8080/beer   return one register


## Steps to Deploy and Run Application with java 8 (1.8.0_332) and tomcat 8 (8.5.78)

1. Build application using command `./gradlew build`.
2. Build Docker image using command `docker build -f Dockerfile_java_8_tomcat8 -t gormdataservice8_tomcat8:0.1 .`.
3. Start a new Docker container using command `docker run -it --rm -p 8080:8080 gormdataservice8_tomcat8:0.1`.
4. Call http://localhost:8080/beer   return one register
