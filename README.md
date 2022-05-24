# GORM Data Services are not injected when deployed to Tomcat


## Steps to Deploy and Run Application with java 8 (8u322-b06-jdk) 

1. Build application using command `./gradlew build`.
2. Build Docker image using command `docker build -f Dockerfile_java_8_tem -t java_8_tem:0.1 .`.
3. Start a new Docker container using command `docker run -it --rm -p 8080:8080 java_8_tem:0.1`.
4. Call http://localhost:8080/beer return one register


