FROM tomcat:9.0.63-jdk11-temurin
COPY build/libs/gorm-data-service-issue-0.1-plain.war $CATALINA_HOME/webapps/ROOT.war
