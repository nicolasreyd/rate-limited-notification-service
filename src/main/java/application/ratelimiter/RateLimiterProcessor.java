package application.ratelimiter;

import domain.User;
import java.time.LocalDateTime;

public abstract class RateLimiterProcessor {

  public Boolean validateLimit(User user) {
    LocalDateTime actualRecordTime = LocalDateTime.now();

    processActionRecord(user, actualRecordTime);
    return !achieveMaxAttempts(user);
  }

  protected void processActionRecord(User user, LocalDateTime actualRecordTime) {
    for (LocalDateTime recordTime : user.getActionsRecords()) {
      if (timeLapseExceeded(recordTime, actualRecordTime)) {
        user.removeRecord(recordTime);
      }
    }
    user.addRecord(actualRecordTime);
  }

  protected boolean achieveMaxAttempts(User user) {
    return user.getActionsRecordsSize() >= getMaxNotifications();
  }

  protected Boolean timeLapseExceeded(LocalDateTime recordTime, LocalDateTime actualRecordTime) {
    return getTimeDifference(recordTime, actualRecordTime) >= getRateLimit();
  }

  abstract long getTimeDifference(LocalDateTime recordTime, LocalDateTime actualRecordTime);

  abstract int getMaxNotifications();

  abstract int getRateLimit();
}
