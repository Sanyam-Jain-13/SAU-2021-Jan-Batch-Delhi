##To Start Zoo-Server :
kafka_2.12-2.7.0 % sh bin/zookeeper-server-start.sh config/zookeeper.properties

##To Start Apache Kafka : 
sh bin/kafka-server-start.sh config/server.properties

##To Create a Topic :
kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic {topic name}
