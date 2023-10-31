package application;

import application.ratelimiter.RateLimiterFactory;
import application.ratelimiter.RateLimiterProcessor;
import domain.Notification;

public class NotificationServiceImpl implements NotificationService{

  @Override
  public Integer send(Notification notification) {
    RateLimiterFactory rateLimiterFactory = new RateLimiterFactory();
    RateLimiterProcessor processor = rateLimiterFactory.getProcessor(notification);

    if (processor.validateLimit(notification.getUser())) {
      System.out.println("Message sent.");
      return 1;
    } else {
      System.out.println("Too many messages sent.");
      return 0;
    }
  }
}
