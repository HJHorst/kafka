package com.hjh.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

	public static Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args).close();
	}

	@Autowired
	private KafkaTemplate<String, String> template;

	private final CountDownLatch latch = new CountDownLatch(3);

	@Override
	public void run(String... args) throws Exception {
		this.template.send("test", "foo1");
		this.template.send("test", "foo2");
		this.template.send("test", "foo3");
		latch.await(60, TimeUnit.SECONDS);
		logger.info("All received");
	}

	@KafkaListener(topics = "test")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info(cr.toString());
		latch.countDown();
	}

}
