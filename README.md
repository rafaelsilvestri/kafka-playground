# Overview
This is a placeholder for Kafka practice.

## Getting Started
```bash
$ docker-compose up --build
$ ./create-topics.sh
```

Besides the Kafka and Zookeeper, the compose will create a [Kafdrop](https://github.com/obsidiandynamics/kafdrop) that is a handy Web UI for visualize Kafka Topics, Partitions and messages. You can open Kafdrop in a browser by typing http://localhost:9000/


## NodeJS - Consumers
```bash
$ cd nodejs
# open each consumer in a separate window
$ node consumer.js 
$ node consumer_sum.js
$ node consumer_avg.js
```

## Python - Producer
```bash
$ cd python
# enable virtualenv
$ source .env3/bin/activate
# execute the producer
$ python3 producer.py
# press CTRL+C to stop producing messages
```


### References

https://medium.com/trainingcenter/apache-kafka-codifica%C3%A7%C3%A3o-na-pratica-9c6a4142a08f
https://www.baeldung.com/spring-kafka
https://docs.spring.io/spring-kafka/reference/html
