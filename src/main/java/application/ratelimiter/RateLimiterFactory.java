package application.ratelimiter;

import domain.Notification;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RateLimiterFactory {

  public static final String STATUS = "status";
  public static final String MARKETING = "marketing";

  public RateLimiterProcessor getProcessor(Notification notification) {
    RateLimiterProcessor processor = new BasicRateLimit();
    switch (notification.getType()) {
      case STATUS:
        processor = new RateLimiterStatusByHours();
        break;
      case MARKETING:
        processor = new RateLimiterMarketingByMinutes();
        break;
    }

    return processor;
  }
}
