#!/bin/bash

echo "***** Initializing kubernetes cluster *****"

kind create cluster --config kind-config.yml

echo "***** Your cluster is up and ready to use *****"