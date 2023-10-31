package application;

import domain.Notification;

public interface NotificationsGateway {
  Integer sendNotification(Notification notification);
}
