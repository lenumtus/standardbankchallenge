#!/bin/bash

ssh  ${SERVER_USER}@${SERVER_HOST} -i key.pem -t -t -o StrictHostKeyChecking=no << 'ENDSSH'
sudo docker pull lenumtusdocker/standardbankchallenge:latest

CONTAINER_NAME=standardbankchallenge
if [ "$(sudo docker ps -qa -f name=$CONTAINER_NAME)" ]; then
    if [ "$(sudo docker ps -q -f name=$CONTAINER_NAME)" ]; then
        sudo echo "Container is running -> stopping it..."
        sudo docker stop $CONTAINER_NAME;
    fi
fi
echo "running new container ......... "
sudo docker run -d --rm -p 8999:8999 --name $CONTAINER_NAME lenumtusdocker/standardbankchallenge:latest

exit
ENDSSH

if [ $? -eq 0 ]; then
  exit 0
else
  exit 1
fi


echo "Deployed"
