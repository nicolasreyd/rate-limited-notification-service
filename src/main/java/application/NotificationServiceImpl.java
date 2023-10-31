package application;

import application.ratelimiter.RateLimiterFactory;
import application.ratelimiter.RateLimiterProcessor;
import domain.Notification;
import java.util.logging.Logger;


public class NotificationServiceImpl implements NotificationService {
  NotificationsGateway notificationsGateway = new NotificationsGatewayImpl();
  private static final Logger log = Logger.getLogger(NotificationServiceImpl.class.toString());

  @Override
  public Integer send(Notification notification) {
    RateLimiterFactory rateLimiterFactory = new RateLimiterFactory();
    RateLimiterProcessor processor = rateLimiterFactory.getProcessor(notification);

    if (processor.validateLimit(notification.getUser())) {
      log.info("Message sent.");
      return notificationsGateway.sendNotification(notification);
    }
    log.warning("Too many messages sent.");
    return 0;
  }
}
