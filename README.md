# GORM Data Services are not injected when deployed to Tomcat


## Steps to Deploy and Run Application

1. Build application using command `./gradlew build`.
2. Build Docker image using command `docker build -t gormdataservice:0.1 .`.
3. Start a new Docker container using command `docker run -it --rm -p 8080:8080 gormdataservice:0.1`.
4. Call curl http://localhost:8080/beer   return one register
