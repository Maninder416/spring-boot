#!/bin/bash

declare app=docker-compose-app.yml
declare app_db=docker-compose.yml

clean(){
  mvn clean compile package
}

start(){
  echo '***** Starting all docker containers *****'
  clean
  docker-compose -f $app -f $app_db up -d
  docker-compose -f $app -f $app_db logs -f

}

stop(){
  echo '***** Stopping all docker containers *****'
  docker-compose -f $app -f $app_db down -v
}

action="start"

if [[ "$#" != "0" ]]
then
  action=$@

fi

eval ${action}