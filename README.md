rswebapp
========

RedString Matching service backend webapp


Java 7 (JDK7), Tomcat 7, Eclipse IDE for Java EE Developers Luna (4.4)

Web Server : Tomcat 7

SQL database: DEV : HSQLDB in memory

Eclipse DEV environment setup: TBD


To build a war file for development environment, using
```bash
mvn clean install
```

TBD: To package a war file for production environment, using 
```bash
mvn clean install -Pprod
```

To run the webapp via maven command line (No Tomcat needed)
```bash
mvn jetty:run
```

To deploy it to Tomcat server
Copy the rswebapp.war to Tomcat webapps folder
Or
Copy the target/rswebapp folder to Tomcat webapps folder