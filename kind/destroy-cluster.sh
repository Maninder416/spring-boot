#!/bin/zsh

echo "***** Destroying Kubernetes cluster *****"

kind delete cluster --name sb-k8s-series

