# Kafka Producer & Consumer in Spring Boot
This project demonstrates the implementation of Kafka Producer and Consumer using Spring Boot. The producer sends messages to Kafka topics, while the consumer listens and processes messages from the topics.

## Features
✅ Producer and Consumer configurations using Spring Kafka.

✅ Sending and receiving simple messages (String) and JSON objects.

✅ Using Kafka partitions for optimized message consumption.

✅ Error handling and logging with SLF4J Logger

## 🛠 Kafka Producer Configuration
📍 File: KafkaProducerConfig.java
Configures the Kafka producer properties (e.g., Bootstrap server, Serializers).

Defines a Kafka topic (Specific-topic) with 3 partitions.

Creates a KafkaTemplate<String, Object> to send messages to Kafka.

    @Bean
    public NewTopic createTopic() {
        return new NewTopic("Specific-topic", 3, (short) 1);
        }

## Producer Methods
📌 Sending Plain Text Messages

/publish/{message} → Publishes 100,000 messages to a Kafka topic.

/publishTo/{message} → Sends messages to specific partitions.

📌 Sending JSON Object (Customer Data)

/publish/customerDetails → Publishes a Customer object to a topic.

## 🛠 Kafka Consumer Configuration
📍 File: KafkaConsumerConfig.java

Configures the Kafka consumer properties (e.g., Deserializers, Group ID).

Uses JsonDeserializer to deserialize Customer objects.

Defines a listener container factory to consume messages.

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
        }

## 📥 Kafka Consumer Implementation

📍 File: KafkaMessageListener.java

Listens to messages from multiple topics.

Consumes Customer JSON objects from Object-5 topic.

Reads from a specific partition (partition 2 of Specific-topic).

## Consumer Methods
✅ customerMessage(Customer customer) → Reads Customer object from Kafka.

✅ consumeEvents(String message) → Reads messages only from partition 2 of Specific-topic.

    @KafkaListener(topics = "Specific-topic", topicPartitions = @TopicPartition(topic = "Specific-topic", partitions = {"2"}))
    public void consumeEvents(String message) {
        logger.info("Listening from a particular partition: {}", message);
        }

## 📌 How to Run

### Start Kafka Broker

Make sure Kafka and Zookeeper are running:

    zookeeper-server-start.sh config/zookeeper.properties
    kafka-server-start.sh config/server.properties

### Start Spring Boot Application

Run the application using:

    mvn spring-boot:run
