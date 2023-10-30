package com.notification.service;

import com.notification.service.application.NotificationServiceImpl;

public class MainTest {

  public static void main(String[] args) {
    NotificationServiceImpl notificationService = new NotificationServiceImpl();
    notificationService.send();
  }

}
