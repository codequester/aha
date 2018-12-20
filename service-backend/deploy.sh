#!/bin/bash

APP_NAME=$1
ENV_VAL=$2

mvn clean package
docker build -t service-backend:latest .
docker tag service-backend:latest shankar29/service-backend:latest
docker push shankar29/service-backend:latest
oc new-app --docker-image=shankar29/service-backend:latest --name=$APP_NAME --env env=$ENV_VAL
oc create route passthrough  service-backend --service=service-backend --port=8443
