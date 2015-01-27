SCRIPT=$(readlink -f $0)
SCRIPTPATH=`dirname $SCRIPT`
java -jar $SCRIPTPATH/sqltool.jar --sql "shutdown;" --rcfile $SCRIPTPATH/sqltool.rc  localdb1
echo "hsqldb was shutdown"
