SCRIPT=$(readlink -f $0)
SCRIPTPATH=`dirname $SCRIPT`
java -jar $SCRIPTPATH/sqltool.jar --rcfile $SCRIPTPATH/sqltool.rc localdb1
