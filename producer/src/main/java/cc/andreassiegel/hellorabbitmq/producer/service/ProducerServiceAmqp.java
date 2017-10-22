package cc.andreassiegel.hellorabbitmq.producer.service;

import cc.andreassiegel.hellorabbitmq.common.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerServiceAmqp implements ProducerService {

  private final AmqpTemplate amqpTemplate;
  private final String broadcastExchange;

  @Autowired
  public ProducerServiceAmqp(AmqpTemplate amqpTemplate, Exchange fanoutExchange) {

    this.amqpTemplate = amqpTemplate;
    this.broadcastExchange = fanoutExchange.getName();
  }

  @Override
  public void broadcast(Event event) {

    try {
      amqpTemplate.convertAndSend(broadcastExchange, "", event.toString());
      log.info("Send message to fanout exchange '{}': {}", broadcastExchange, event);
    } catch (AmqpException e) {
      log.warn("Sending message to fanout exchange '{}' failed: {}", broadcastExchange, e.toString());
    }
  }
}
