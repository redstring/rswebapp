##Eclipse Dev  environment setup

Java 8 (JDK8), Tomcat 8, Eclipse IDE for Java EE Developers Luna (4.4)

Web Server : Tomcat 8 or Jetty 9 (for local test run, no need to download jetty)

SQL database: DEV : HSQLDB, Prod: MySQL JDBC

Build Tool : maven 3


####Step 1: Open terminal to run command
Go to command line and clone the project to local disk
, then convert it to eclipse project so that it is easier to import it into eclipse)
```bash
$ git clone git@github.com:redstring/rswebapp.git
$ cd rswebapp
$ mvn eclipse:eclipse
```


####Step2: Open Eclipse
File -> Import -> Existing Projects into Workspace

Make sure the Destination directory is not in your existing eclipse workspace

Otherwise, you will see this Error “.. overlaps the location of another project..” when trying to create a new project


####Step 3: 
Right click your project, -> Configure -> Convert to Maven project

Hit Refresh in eclipse

Right click your projcet, -> Maven -> Update Project

Right click pom.xml -> Maven Install

####Step 4: 
(Optional ) You might need to download apache Tomcat 8 and point the server to that folder

Window -> Preferences -> Server -> Server Runtime Environment -> Add -> Apache Tomcat 8 

Add in your local tomcat location as Tomcat server


####Step 5: 
Right click project(rswebapp) -> Properties -> 

  Project Facets -> Click Convert to facedted form... ->(select Dynamic Web Module 3.0, java 1.8) 
  
  Click Further configuration available -> Content directory set to "src/main/webapp"


* * *
####Step 6: 
(Optional): Right click project (rswebapp) -> Properties -> Deployement Assembly -> add -> click on "Java Build Path Entries" ->

select "Maven Dependencies"  ->click Finish.
* * *

##Local test run method (Without installing Tomcat)
Requires JDK8, maven 3
```bash
$ mvn package
$ ./run.sh
```

Open browser, and type in the url

http://localhost:8080

##hsqldb in local dev environment, go into hsqldb folder
```bash
#start_hsqldb
$ ./start_db1.sh
#stop_hsqldb
$ ./stop_db1.sh
#check if hsqldb is running
$ ./check_hsqldb_status.sh
#connect to hsqldb to run some sql
$ ./connect_hsqldb_cml.sh
```