package cc.andreassiegel.hellorabbitmq.producer.controller;

import cc.andreassiegel.hellorabbitmq.common.model.Event;
import cc.andreassiegel.hellorabbitmq.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProducerRestController {

  private final ProducerService<?> producerService;

  @Autowired
  public ProducerRestController(ProducerService<?> producerService) {

    this.producerService = producerService;
  }

  @RequestMapping(method = POST, path = "/broadcast", consumes = APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> sendBroadcastEvent(@RequestBody Event event) {

    producerService.broadcast(event);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = POST, path = "/send/topic/{routingKey:.+}", consumes = APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> sendTopicEvent(@PathVariable("routingKey") String routingKey, @RequestBody Event event) {

    producerService.sendToTopic(routingKey, event);
    return ResponseEntity.noContent().build();
  }
}
