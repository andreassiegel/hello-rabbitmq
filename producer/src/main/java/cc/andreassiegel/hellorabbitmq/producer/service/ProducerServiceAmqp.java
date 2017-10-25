package cc.andreassiegel.hellorabbitmq.producer.service;

import cc.andreassiegel.hellorabbitmq.common.config.properties.ExchangeProperties;
import cc.andreassiegel.hellorabbitmq.common.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerServiceAmqp implements ProducerService {

  private final AmqpTemplate amqpTemplate;
  private final String broadcastExchange;
  private final String topicExchange;

  @Autowired
  public ProducerServiceAmqp(AmqpTemplate amqpTemplate, ExchangeProperties properties) {

    this.amqpTemplate = amqpTemplate;
    this.broadcastExchange = properties.getFanout();
    this.topicExchange = properties.getTopic();
  }

  @Override
  public void broadcast(Event event) {

    try {
      amqpTemplate.convertAndSend(broadcastExchange, "", event);
      log.info("Send message to fanout exchange '{}': {}", broadcastExchange, event);
    } catch (AmqpException e) {
      log.warn("Sending message to fanout exchange '{}' failed: {}", broadcastExchange, e.toString());
    }
  }

  @Override
  public void sendToTopic(String routingKey, Event event) {

    routingKey = topicExchange + "." + routingKey;
    try {
      amqpTemplate.convertAndSend(topicExchange, routingKey, event);
      log.info("Send message to topic exchange '{}' with routing key '{}': {}", topicExchange, routingKey, event);
    } catch (AmqpException e) {
      log.warn("Sending message to topic exchange '{}' with routing key '{}' failed: {}", topicExchange, routingKey, e.toString());
    }
  }
}
