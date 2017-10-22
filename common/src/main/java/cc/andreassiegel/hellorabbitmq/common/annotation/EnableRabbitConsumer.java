package cc.andreassiegel.hellorabbitmq.common.annotation;

import cc.andreassiegel.hellorabbitmq.common.config.CommonConfiguration;
import cc.andreassiegel.hellorabbitmq.common.config.ConsumerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({CommonConfiguration.class, ConsumerConfiguration.class})
public @interface EnableRabbitConsumer {
}
