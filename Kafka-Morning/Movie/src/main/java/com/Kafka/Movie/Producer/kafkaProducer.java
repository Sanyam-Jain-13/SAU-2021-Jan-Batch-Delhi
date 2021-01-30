package com.Kafka.Movie.Producer;

import com.Kafka.Movie.Controller.kafkaController;
import com.Kafka.Movie.Model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class kafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProperties.Producer.class);
    @Autowired
    public KafkaTemplate<String,Movie> kafkaTemplate;

    String topic = kafkaController.TOPIC;

    public void addMovie(Movie movie)
    {
        logger.info(String.format("Producing Movie: %s", movie));
        kafkaTemplate.send(topic,movie);
    }
}
