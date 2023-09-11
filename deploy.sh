#!/bin/bash

ssh -i  ${SERVER_USER}@${SERVER_HOST} -i key.pem -t -t -o StrictHostKeyChecking=no << 'ENDSSH'
docker pull lenumtusdocker/standardbankchallenge:latest

CONTAINER_NAME=standardbankchallenge
if [ "$(docker ps -qa -f name=$CONTAINER_NAME)" ]; then
    if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
        echo "Container is running -> stopping it..."
        docker stop $CONTAINER_NAME;
    fi
fi

docker run -d --rm -p 8089:8089 --name $CONTAINER_NAME lenumtusdocker/standardbankchallenge:latest

exit
ENDSSH

if [ $? -eq 0 ]; then
  exit 0
else
  exit 1
fi


echo "Deployed"
