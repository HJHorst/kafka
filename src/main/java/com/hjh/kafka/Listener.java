package com.hjh.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Listener {

    public static Logger logger = LoggerFactory.getLogger(Listener.class);

    private final CountDownLatch latch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "test")
    public void listen1(String foo) {
        logger.info(foo);
        this.latch1.countDown();
    }

}