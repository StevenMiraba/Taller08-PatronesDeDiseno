package strategy;

public class FacebookNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String notificationInfo) {
        System.out.println("Sending Facebook notification: " + notificationInfo);
    }
}
