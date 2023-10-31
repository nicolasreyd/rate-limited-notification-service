package application.ratelimiter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RateLimiterStatusByHours extends RateLimiterProcessor {

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

}
