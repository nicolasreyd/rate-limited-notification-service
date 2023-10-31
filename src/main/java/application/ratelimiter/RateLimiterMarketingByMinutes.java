package application.ratelimiter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RateLimiterMarketingByMinutes extends RateLimiterProcessor {

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

}
