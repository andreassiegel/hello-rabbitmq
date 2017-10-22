package cc.andreassiegel.hellorabbitmq.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.springframework.amqp.core.ExchangeTypes.FANOUT;

@Component
@Slf4j
public class ConsumerServiceRabbit {

  @RabbitListener(bindings = @QueueBinding(value = @Queue(durable = "true"),
      exchange = @Exchange(value = "${messaging.exchange.fanout}", type = FANOUT, durable = "true")))
  public void processMessage(String content) {

    log.info("Received message {}", content);
  }
}
