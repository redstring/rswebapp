##Eclipse Dev  environment setup

Java 7 (JDK7), Tomcat 7, Eclipse IDE for Java EE Developers Luna (4.4)

Web Server : Tomcat 7 or Jetty 9 (for local test run, no need to download jetty)

SQL database: DEV : HSQLDB, Prod: MySQL JDBC

Build Tool : maven 3


####Open elipse

####Step1: 
File -> Import -> Git -> Projects from Git -> Clone from URI (Fill out all the details) -> Import as general project

Make sure the Destination directory is not in your existing eclipse workspace

Otherwise, you will see this Error “.. overlaps the location of another project..” when trying to create a new project

####Step 2: 
Go to command line and the project directory (convert it to eclipse project so that it is compatible to eclipse)
```bash
$ cd rswebapp
$ mvn eclipse:eclipse
```
####Step 3: 
Hit Refresh in eclipse

####Step 4: 
(Optional ) You might need to download apache Tomcat 7 and point the server to that folder

Window -> Preferences -> Server -> Server Runtime Environment -> Add -> Apache Tomcat 7 

Add in your local tomcat location as Tomcat server


####Step 5: 
Right click project(rswebapp) -> Properties -> 

  Project Facets -> Click Convert to facedted form... ->(select Dynamic Web Module 3.0, java 1.7) 
  
  Click Further configuration available -> Content directory set to "src/main/webapp"

####Step 6: 
Right click project (rswebapp) -> Configure -> Convert to maven project

* * *
####Step 7: 
(Optional): Right click project (rswebapp) -> Properties -> Deployement Assembly -> add -> click on "Java Build Path Entries" ->

select "Maven Dependencies"  ->click Finish.
* * *

##Local test run (Without installing Tomcat)
Requires JDK7, maven 3
```bash
$ mvn jetty:run
```
Open browser, and type in the url

http://localhost:8080/index.jsp

