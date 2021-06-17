#!/usr/bin/env bash

export JAVA_HOME=/usr/lib/jvm/java-15-oracle

#Stop and remove all containers
./stats/src/main/resources/scripts/stop_n_remove_containers.sh ;

#Set exit on failure flag
set -e

#Build project
cd ./stats ;
./gradlew clean build docker ;
cd .. ;

#Run containers
docker-compose up