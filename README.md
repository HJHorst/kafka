bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties

bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning


WINDOWS:

start bin\windows\zookeeper-server-start.bat config\zookeeper.properties

start bin\windows\kafka-server-start.bat config\server.properties

bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

start bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test

start bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning

