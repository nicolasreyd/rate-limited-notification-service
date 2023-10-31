package application;

import domain.Notification;

public class NotificationsGatewayImpl implements NotificationsGateway {

  @Override
  public Integer sendNotification(Notification notification) {
    return 1;
  }
}
