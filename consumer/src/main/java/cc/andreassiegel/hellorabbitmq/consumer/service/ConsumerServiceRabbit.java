package cc.andreassiegel.hellorabbitmq.consumer.service;

import cc.andreassiegel.hellorabbitmq.common.annotation.FanoutListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerServiceRabbit {

  @FanoutListener
  public void processMessage(String content) {

    log.info("Received message {}", content);
  }
}
