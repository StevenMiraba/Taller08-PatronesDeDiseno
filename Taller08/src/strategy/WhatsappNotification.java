package strategy;

public class WhatsappNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String notificationInfo) {
        System.out.println("Sending Whatsapp notification: " + notificationInfo);
    }
}
