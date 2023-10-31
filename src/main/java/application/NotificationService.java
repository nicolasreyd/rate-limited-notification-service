package application;

import domain.Notification;

public interface NotificationService {
  Integer send(Notification notification);
}
