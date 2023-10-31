package application.ratelimiter;

import domain.Notification;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RateLimiterStatusByHours extends RateLimiterProcessor {

  public static final String STATUS = "status";

  @Override
  long getTimeDifference(LocalDateTime recordTime, LocalDateTime actualRecordTime) {
    return ChronoUnit.HOURS.between(recordTime, actualRecordTime);
  }

  @Override
  int getMaxNotifications() {
    return 3;
  }

  @Override
  int getRateLimit() {
    return 1;
  }

  @Override
  boolean applies(Notification notification) {
    return STATUS.equals(notification.getType());
  }

}
