SCRIPT=$(readlink -f $0)
SCRIPTPATH=`dirname $SCRIPT`
nohup java -cp $SCRIPTPATH/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb-file --dbname.0 db1 >> hsqldb-server-nohup.out 2>&1 &

