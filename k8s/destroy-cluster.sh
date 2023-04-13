#!/bin/bash

echo "***** Destroying kubernetes cluster *****"

kind delete cluster --name kind-testing-cluster