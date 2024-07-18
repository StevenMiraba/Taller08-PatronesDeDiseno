package strategy;

public class OrkutNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String notificationInfo) {
        System.out.println("Sending Orkut notification: " + notificationInfo);
    }
}
