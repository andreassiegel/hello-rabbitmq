package cc.andreassiegel.hellorabbitmq.producer;

import cc.andreassiegel.hellorabbitmq.common.annotation.EnableRabbitProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbitProducer
@SpringBootApplication
public class ProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProducerApplication.class, args);
  }
}
