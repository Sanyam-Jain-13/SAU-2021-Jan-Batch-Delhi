package com.Kafka.Movie.Controller;

import com.Kafka.Movie.Model.Movie;
import com.Kafka.Movie.Producer.kafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class kafkaController {

    public static final String TOPIC = "Movie_Topic"; //javainuse-topic

    @Autowired
    kafkaProducer producer;

    @Autowired
    public KafkaTemplate<String,Movie> kafkaTemplate;
    String topic = kafkaController.TOPIC;


    @PostMapping("/addMovie")
    public String postMessage(@RequestBody Movie movie)
    {
        producer.addMovie(movie);
        return movie.getName()+" successfully Published!!";
    }
}
