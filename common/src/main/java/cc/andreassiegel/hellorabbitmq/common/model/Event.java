package cc.andreassiegel.hellorabbitmq.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Event<PAYLOAD> {

  private String key;
  private PAYLOAD payload;
}
