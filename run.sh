#!/bin/bash
SCRIPT=$(readlink -f $0)
SCRIPTPATH=`dirname $SCRIPT`
#Check memory size : ps -u username -o rss,etime,pid,command
export JAVA_OPTIONS="-Xms 32m -Xmx256m -XX:MaxPermSize=265m"
java -jar $SCRIPTPATH/jetty/jetty-runner-9.2.6.v20141205.jar --port 8080 --log $SCRIPTPATH/jetty.log $SCRIPTPATH/target/rswebapp.war
