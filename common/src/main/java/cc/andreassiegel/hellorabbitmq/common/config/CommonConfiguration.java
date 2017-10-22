package cc.andreassiegel.hellorabbitmq.common.config;

import cc.andreassiegel.hellorabbitmq.common.config.properties.ExchangeProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties({ExchangeProperties.class})
@Slf4j
public class CommonConfiguration {

  @Bean
  public MessageConverter messageConverter() {

    return new Jackson2JsonMessageConverter();
  }
}
