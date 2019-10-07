package com.hjh.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {

    public static Logger logger = LoggerFactory.getLogger(Listener.class);

    @KafkaListener(id = "foo", topics = "test")
    public void listen1(String foo) {
        logger.info(foo);
    }

}