#!/bin/bash

USAGE="Usage: $0 <port>"

if [ "$#" == "0" ]; then
	echo "$USAGE"
	exit 1
fi

port=$1
adminPort=`expr $1 + 10`

while (( "$#" )); do

        echo "*****************************************************"
        echo "*                                                   *"
	echo "*   Starting service on port: " $port "             *"
        echo "*   Admin services available on port: " $adminPort "*"
        echo "*                                                   *"
        echo "*****************************************************"

java -Ddw.http.port=$port -Ddw.http.adminPort=$adminPort -jar target/workerservice-0.0.1-SNAPSHOT.jar server /Users/tmorgan/Documents/workspace/WorkerService/src/main/java/com/rms/workerservice/worker-service.yml

shift

done
