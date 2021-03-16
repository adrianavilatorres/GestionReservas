#!/bin/bash

docker stop docs_adminer_1 docs_db_1
docker rm docs_adminer_1 docs_db_1
docker rmi adminer:latest mysql:latest
docker volume prune
docker-compose -f stack.yml up  -d
docker logs docs_db_1