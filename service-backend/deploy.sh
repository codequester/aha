#!/bin/bash

APP_NAME=$1
ENV_VAL=$2

mvn clean package
docker build -t service-backend:latest .
docker tag service-backend:latest shankar29/service-backend:latest
docker push shankar29/service-backend:latest
oc new-app --docker-image=shankar29/service-backend:latest --name=$APP_NAME --env env=$ENV_VAL
oc create route passthrough  service-backend --service=service-backend --port=8443

#oc set probe dc/service-backend --readiness --get-url=https://:28443/service-backend/ --initial-delay-seconds=10 --failure-threshold=3 --insecure-skip-tls-verify=true
#oc set probe dc/service-backend --remove --readiness

####
## Since we implemented 2way/mtls enabled (check the connector propertie in server.xml for port 28443. The client auth enabled = true makes it 2 way SSL), we cannot
## use https readiness or liveness probe. Due to that we have to rely on exec for readiness probe. See below
####
oc set probe dc/service-backend --readiness --initial-delay-seconds=123 --failure-threshold=3 -- cat /tmp/ready.txt 