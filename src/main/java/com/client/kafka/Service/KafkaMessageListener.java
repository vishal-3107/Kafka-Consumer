package com.client.kafka.Service;

import com.client.kafka.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

//    @KafkaListener(topics = "Zoo", groupId = "Ikka-group-2")
//    public void consume1(String message)
//    {
//        logger.info("consumer1 consume the message {} ", message);
//    }
//
//    @KafkaListener(topics = "Zoo", groupId = "Ikka-group-2")
//    public void consume2(String message)
//    {
//        logger.info("consumer2 consume the message {} ", message);
//    }
//
//    @KafkaListener(topics = "Zoo", groupId = "Ikka-group-2")
//    public void consume3(String message)
//    {
//        logger.info("consumer3 consume the message {} ", message);
//    }
//
//    @KafkaListener(topics = "Zoo", groupId = "Ikka-group-2")
//    public void consume4(String message)
//    {
//        logger.info("consumer4 consume the message {} ", message);
//    }
//
//    @KafkaListener(topics = "Zoo", groupId = "Ikka-group-2")
//    public void consume5(String message)
//    {
//        logger.info("consumer5 consume the message {} ", message);
//    }

    @KafkaListener(topics = "Object-5", groupId = "New-id")
    public void customerMessage(Customer customer) {
        logger.info("Consumer consume customer object {} ", customer);
    }

    @KafkaListener(topics = "Specific-topic", topicPartitions = @TopicPartition(topic = "Specific-topic", partitions = {"2"}))
    public void consumeEvents(String message) {
        logger.info("Listening from a particular partition of a topic {} ", message);
    }
}
