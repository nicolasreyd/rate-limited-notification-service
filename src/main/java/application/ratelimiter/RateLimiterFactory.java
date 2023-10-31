package application.ratelimiter;

import domain.Notification;
import java.util.ArrayList;
import java.util.List;

public class RateLimiterFactory {
  List<RateLimiterProcessor> availableProcessors;

  public RateLimiterFactory() {
    availableProcessors = new ArrayList<>();
    availableProcessors.add(new RateLimiterStatusByHours());
    availableProcessors.add(new RateLimiterMarketingByMinutes());
    availableProcessors.add(new BasicRateLimit());
  }

  public RateLimiterProcessor getProcessor(Notification notification) {
    return availableProcessors.stream()
        .filter(rateLimiterProcessor -> rateLimiterProcessor.applies(notification))
        .findFirst()
        .orElse(new BasicRateLimit());
  }
}
