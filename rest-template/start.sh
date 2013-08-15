#!/bin/bash

USAGE="Usage: $0 <port>"

if [ "$#" == "0" ]; then
	echo "$USAGE"
	exit 1
fi

port=$1
adminPort=`expr $1 + 10`
jarPath=./target/rest*.jar
ymlPath=./*.yml
sigarPath=./lib


while (( "$#" )); do

        echo "*****************************************************"
        echo "*                                                   *"
	echo "*   Starting service on port: " $port "             *"
        echo "*   Admin services available on port: " $adminPort "*"
        echo "*                                                   *"
        echo "*****************************************************"

java -Ddw.http.port=$port -Ddw.http.adminPort=$adminPort -Dorg.hyperic.sigar.path=$sigarPath -jar $jarPath server $ymlPath


echo "java -Ddw.http.port=$port -Ddw.http.adminPort=$adminPort -Dorg.hyperic.sigar.path=$sigarPath -jar $jarPath server $ymlPath"

shift

done
