package cc.andreassiegel.hellorabbitmq.consumer.service;

import cc.andreassiegel.hellorabbitmq.common.annotation.FanoutListener;
import cc.andreassiegel.hellorabbitmq.common.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerServiceRabbit {

  @FanoutListener
  public void processMessage(@Payload Event content) {

    log.info("Received message object {}", content);
  }
}
