package cc.andreassiegel.hellorabbitmq.consumer.service;

import cc.andreassiegel.hellorabbitmq.common.annotation.FanoutListener;
import cc.andreassiegel.hellorabbitmq.common.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.springframework.amqp.core.ExchangeTypes.TOPIC;

@Component
@Slf4j
public class ConsumerServiceRabbit {

  @FanoutListener
  public void fanoutConsumer(@Payload Event event, @Headers Map<String, Object> headers) {

    log.info("Received message object on fanout: {}", event);
    log.info("Headers: {}", headers);
  }

  @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "log-consumer", durable = "true"), key = "${messaging.exchange.topic}" + ".#",
      exchange = @Exchange(value = "${messaging.exchange.topic}", type = TOPIC, durable = "true")))
  public void topicListener(@Payload Event event, @Headers Map<String, Object> headers) {

    log.info("Received message object on topic exchange: {}", event);
    log.info("Headers: {}", headers);
  }
}
