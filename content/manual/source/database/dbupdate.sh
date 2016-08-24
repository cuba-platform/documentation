#!/bin/sh

DB_URL="jdbc:postgresql://localhost/mydb"

APP_CORE_DIR="./../webapps/app-core"
WEBLIB="$APP_CORE_DIR/WEB-INF/lib"
SCRIPTS="$APP_CORE_DIR/WEB-INF/db"
TOMCAT="./../lib"
SHARED="./../shared/lib"

CLASSPATH=""
for jar in `ls "$TOMCAT/"`
do
  CLASSPATH="$TOMCAT/$jar:$CLASSPATH"
done

for jar in `ls "$WEBLIB/"`
do
  CLASSPATH="$WEBLIB/$jar:$CLASSPATH"
done

for jar in `ls "$SHARED/"`
do
  CLASSPATH="$SHARED/$jar:$CLASSPATH"
done

java -cp $CLASSPATH com.haulmont.cuba.core.sys.utils.DbUpdaterUtil \
 -dbType postgres -dbUrl $DB_URL \
 -dbUser $1 -dbPassword $2 \
 -scriptsDir $SCRIPTS \
 -$3
