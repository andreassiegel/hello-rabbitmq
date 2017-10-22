package cc.andreassiegel.hellorabbitmq.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("messaging.exchange")
public class ExchangeProperties {

  private String fanout;
}
