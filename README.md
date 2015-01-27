rswebapp
========

RedString Matching service backend webapp


Java 8 (JDK8), Tomcat 8, Eclipse IDE for Java EE Developers Luna (4.4)

Web Server : Tomcat 8

SQL database: MySQL or HSQLDB in file


To build a war file for development environment, using
```bash
mvn clean install
```


To run the webapp via maven command line (No Tomcat needed)
```bash
./run.sh
```

To deploy it to Tomcat server
Copy the rswebapp.war to Tomcat webapps folder
Or
Copy the target/rswebapp folder to Tomcat webapps folder
Or in AWS BeansTalk
Upload rswebapp.war