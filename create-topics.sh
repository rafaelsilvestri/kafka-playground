#!/bin/sh

echo "Creating topic..."
docker exec kafka1  \
kafka-topics --create --topic kafka-python-topic \
--partitions 1 --replication-factor 1 \
--if-not-exists --zookeeper zookeeper1:2181