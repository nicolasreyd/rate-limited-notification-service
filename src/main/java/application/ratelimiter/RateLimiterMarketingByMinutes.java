package application.ratelimiter;

import domain.Notification;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RateLimiterMarketingByMinutes extends RateLimiterProcessor {

  private static final String MARKETING = "marketing";

  @Override
  long getTimeDifference(LocalDateTime recordTime, LocalDateTime actualRecordTime) {
    return ChronoUnit.MINUTES.between(recordTime, actualRecordTime);
  }

  @Override
  int getMaxNotifications() {
    return 2;
  }

  @Override
  int getRateLimit() {
    return 30;
  }

  @Override
  boolean applies(Notification notification) {
    return MARKETING.equals(notification.getType());
  }

}
