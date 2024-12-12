#!/bin/bash

cd /opt/sqoop
tar -xf /opt/sqoop/sqoop.tar.gz
mv /opt/sqoop/sqoop-1.4.7.bin__hadoop-2.6.0 /usr/lib/sqoop

export SQOOP_HOME=/usr/lib/sqoop
export PATH=$PATH:$SQOOP_HOME/bin
source ~/.bashrc
cp /opt/sqoop/sqoop-env.sh /usr/lib/sqoop/conf/sqoop-env.sh
cp /opt/sqoop/postgresql-42.2.19.jre6.jar /usr/lib/sqoop/lib
cp /opt/sqoop/postgresql-42.2.19.jre6.jar $HIVE_HOME/lib
cd $HIVE_HOME/lib
cp hive-common-2.3.2.jar $SQOOP_HOME/lib
hdfs dfs -rm -r /user/sqoop
hdfs dfs -mkdir /user/sqoop
