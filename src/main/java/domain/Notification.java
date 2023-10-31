package domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Notification {
  String type;
  User user;
  String content;
}
