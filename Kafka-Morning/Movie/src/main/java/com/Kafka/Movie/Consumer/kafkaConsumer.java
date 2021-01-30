package com.Kafka.Movie.Consumer;

import com.Kafka.Movie.Controller.kafkaController;
import com.Kafka.Movie.Model.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;


@Component
public class kafkaConsumer {

    //Corresponding to each year we have a map which shows no of movies done by each actor
    HashMap<Integer,HashMap<String,Integer>> TrendingMovies=new HashMap<Integer,HashMap<String,Integer>>();

    //Corresponding to each year we have a trending actor
    HashMap<Integer,String> topTrending=new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(KafkaProperties.Producer.class);

    @KafkaListener(topics = kafkaController.TOPIC)
    public void listen(String movie) throws IOException
    {
        //ObjectMapper class ObjectMapper provides functionality for reading and writing JSON, either to and from basic POJOs
        Movie newMovie = new ObjectMapper().readValue(movie, Movie.class);

        //Temperory map
        HashMap<String,Integer> tempMap= new HashMap<>();

        //If already the year is in the map :-
        if(TrendingMovies.containsKey(newMovie.getYear())) {

            //Get the Map for <Actor,Count of no of movies>
            tempMap=TrendingMovies.get(newMovie.getYear());

            //If actor already in map, then increase the count otherwise initialise with 1
            tempMap.put(newMovie.getActor(), tempMap.containsKey(newMovie.getActor()) ? tempMap.get(newMovie.getActor())+1 : 1);

            //If count of current actor >=  Count [Top trending actor of this year], Then update top trending actor
            if(tempMap.get(newMovie.getActor()) >= tempMap.get(topTrending.get(newMovie.getYear())))
            {
                topTrending.put(newMovie.getYear(), newMovie.getActor());
            }
        }

        //Otherwise enter the data into the maps
        else
        {
            topTrending.put(newMovie.getYear(), newMovie.getActor());
            tempMap.put(newMovie.getActor(),1);
        }
        TrendingMovies.put(newMovie.getYear(),tempMap);
        logger.info(String.format("Top Trending Actor of the year : "+ newMovie.getYear() + " is -> " + topTrending.get(newMovie.getYear()) ));
    }
}
