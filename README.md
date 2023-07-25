# WebProgramming
Lab exercises for Web Programming Course 2022/2023

# Modified for DevOps
Runs with either:
a) docker compose up 
b) k3d cluster create <cluster-name> -p "8080:80@loadbalancer"

# 'Nice' features to add in the future include:
- Health probes toward the StatefulSet, to be able to apply all the manifests at once
- Continuous Deployment via Local Runner (reason for private repo)
- Prometheus/Grafana/* - working with logs
