package cc.andreassiegel.hellorabbitmq.consumer;

import cc.andreassiegel.hellorabbitmq.common.annotation.EnableRabbitConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbitConsumer
@SpringBootApplication
public class ConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }
}
