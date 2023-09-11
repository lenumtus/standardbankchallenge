#!/bin/bash

ssh  ${SERVER_USER}@${SERVER_HOST} -i key.pem -t -t -o StrictHostKeyChecking=no << 'ENDSSH'
sudo docker pull lenumtusdocker/standardbankchallenge:latest

CONTAINER_NAME=standardbankchallenge
if [ "$(docker ps -qa -f name=$CONTAINER_NAME)" ]; then
    if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
        echo "Container is running -> stopping it..."
        docker stop $CONTAINER_NAME;
    fi
fi

sudo docker run -d --rm -p 8089:8089 --name $CONTAINER_NAME lenumtusdocker/standardbankchallenge:latest

exit
ENDSSH

if [ $? -eq 0 ]; then
  exit 0
else
  exit 1
fi


echo "Deployed"
