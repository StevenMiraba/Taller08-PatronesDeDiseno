package strategy;

public class TwitterNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String notificationInfo) {
        System.out.println("Sending Twitter notification: " + notificationInfo);
    }
}
