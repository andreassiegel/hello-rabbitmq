package cc.andreassiegel.hellorabbitmq.common.config;

import cc.andreassiegel.hellorabbitmq.common.config.properties.ExchangeProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Slf4j
public class ProducerConfiguration {

  private final ExchangeProperties properties;

  @Autowired
  public ProducerConfiguration(ExchangeProperties exchangeProperties) {

    this.properties = exchangeProperties;
  }

  @Bean
  public Exchange fanoutExchange() {

    log.info("Creating durable Fanout exchange {}", properties.getFanout());
    return ExchangeBuilder.fanoutExchange(properties.getFanout())
        .durable(true)
        .build();
  }
}
