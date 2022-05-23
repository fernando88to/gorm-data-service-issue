# GORM Data Services are not injected when deployed to Tomcat

When using GORM Data Services in a Grail app, everything works fine if the app uses the embedded tomcat, e.g. during testing and bootRun, and even started as a runnable jar.

But when the app is deployed to Tomcat all data services are null.
They are not added to the applicationContext at all, e.g. `Holders.applicationContext.getBean('beerService')` results in a `NoSuchBeanDefinitionException`.


## Sanity check
1. Run `./gradlew bootRun`
2. Verify that calling `curl http://localhost:8080/beer` returns an empty list `[]`

## Steps to reproduce
1. Run `./gradlew bootWar`
2. Copy the WAR to a Tomcat server, e.g. `cp build/libs/notworking.war ~/PATH/TO/LOCAL/TOMCAT/webapps/`
3. Start the Tomcat server, e.g. `./PATH/TO/LOCAL/TOMCAT/bin/startup.sh`
4. Calling the `/beer` endpoint now returns an **Internal server error**, e.g. `curl http://localhost:8080/notworking/beer` returns `{"message":"Internal server error","error":500}`.
5. Checking the log reveals that a `NullPointerException` is thrown because the `beerService` is not injected (ie. `null`).


Stacktrace excerpt: 
```
ERROR --- [nio-8080-exec-2] o.g.web.errors.GrailsExceptionResolver   : NullPointerException occurred when processing request: [GET] /notworking/beer
Cannot invoke method count() on null object. Stacktrace follows:

java.lang.NullPointerException: Cannot invoke method count() on null object
	at gorm.data.service.issue.BeerController.index(BeerController.groovy:23)
	at grails.gorm.transactions.GrailsTransactionTemplate$2.doInTransaction(GrailsTransactionTemplate.groovy:94)
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140)
	at grails.gorm.transactions.GrailsTransactionTemplate.execute(GrailsTransactionTemplate.groovy:91)...
```
