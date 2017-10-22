package cc.andreassiegel.hellorabbitmq.common.config;

import cc.andreassiegel.hellorabbitmq.common.config.properties.ExchangeProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({ExchangeProperties.class})
@Slf4j
public class CommonConfiguration {

}
