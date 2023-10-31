package application;

import domain.Notification;
import domain.User;
import java.time.LocalDateTime;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class NotificationServiceTest {


    @Test
    public void sendNotificationOk() {
        //given
        NotificationService notificationService = new NotificationServiceImpl();

        //then
        Integer result = notificationService.send(Notification.builder()
            .type("status")
            .user(new User("12345"))
            .content("first notification")
            .build());

        //when
        assertEquals(result, 1);
    }

    @Test
    public void sendStatusNotificationAndReject() {
        //given
        NotificationService notificationService = new NotificationServiceImpl();
        User user = new User("12345");
        user.addRecord(LocalDateTime.now().minusHours(2));
        user.addRecord(LocalDateTime.now().minusHours(3));
        user.addRecord(LocalDateTime.now().minusHours(5));
        user.addRecord(LocalDateTime.now().minusMinutes(59));

        //when
        Integer result = notificationService.send(Notification.builder()
            .type("status")
            .user(user)
            .content("first notification")
            .build());

        //then
        assertEquals(result, 1);
    }

    @Test
    public void sendMarketingNotificationAndReject() {
        //given
        NotificationService notificationService = new NotificationServiceImpl();
        User user = new User("12345");
        user.addRecord(LocalDateTime.now().minusHours(2));
        user.addRecord(LocalDateTime.now().minusHours(3));
        user.addRecord(LocalDateTime.now().minusHours(5));
        user.addRecord(LocalDateTime.now().minusMinutes(59));
        user.addRecord(LocalDateTime.now().minusMinutes(25));

        //when
        Integer result = notificationService.send(Notification.builder()
            .type("marketing")
            .user(user)
            .content("first notification")
            .build());

        //then
        assertEquals(result, 1);
    }

}
