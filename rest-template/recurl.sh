#!/bin/bash

USAGE="Usage: $0 <URL>"

if [ "$#" == "0" ]; then
	echo "$USAGE"
	exit 1
fi

url=$1

while (( 1 )); do

curl $url 

shift

done
