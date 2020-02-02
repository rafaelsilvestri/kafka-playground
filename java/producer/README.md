https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html
https://medium.com/@ronaldo.lanhellas/consumindo-multiplos-formatos-no-mesmo-t%C3%B3pico-com-spring-kafka-2-1-76d1cbb62ee3
https://memorynotfound.com/spring-kafka-consume-producer-example/
https://medium.com/@TimvanBaarsen/apache-kafka-cli-commands-cheat-sheet-a6f06eac01b

https://docs.spring.io/spring-kafka/docs/current/reference/html/


List Kafka topics
$KAFKA_HOME/bin/kafka-topics.sh --zookeeper $ZK_HOSTS --list

Produce a message to a Kafka topic
$KAFKA_HOME/usr/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-first-topic
./kafka-console-producer.sh --broker-list localhost:9092 --topic topic1

Consume a Kafka topic
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-first-topic

./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic1

Consume a Kafka topic from the beginning
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-first-topic --from-beginning