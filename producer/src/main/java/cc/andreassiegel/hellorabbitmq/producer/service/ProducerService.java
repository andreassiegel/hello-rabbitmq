package cc.andreassiegel.hellorabbitmq.producer.service;

import cc.andreassiegel.hellorabbitmq.common.model.Event;

public interface ProducerService<PAYLOAD> {

  void broadcast(Event<PAYLOAD> event);
}
