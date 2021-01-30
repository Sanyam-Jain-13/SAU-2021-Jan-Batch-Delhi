```(FOR MAC)```
## First Move into the Kafka Repository in your System & then run these Commands```

## To Start Zoo-Server :
sh bin/zookeeper-server-start.sh config/zookeeper.properties

## To Start Apache Kafka : 
sh bin/kafka-server-start.sh config/server.properties

## To Create a Topic :
kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic {topic name}
