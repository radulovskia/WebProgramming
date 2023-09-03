# WebProgramming
Lab exercises for Web Programming Course 2022/2023

# Modified for DevOps
Modified the existing project with environment variables, Docker multi-stage Dockerfile, docker-compose and kubernetes YAML files, and init.sql script for table initialization. Multiple instances of the app don't work properly because of the in-memory authentication.

Runs with either:
- docker compose up 
- k3d cluster create cluster1 -p "8080:80@loadbalancer"

# 'Nice' features to add in the future include:
- Health probes toward the StatefulSet, to be able to apply all the manifests at once
- Continuous Deployment via Local Runner (reason for private repo)
- Prometheus/Grafana/* - working with metrics
- Logstash/Kibana/Elasticsearch - working with logs
