package strategy;

public class Notifications {
    private NotificationStrategy notificationStrategy;

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void notifyAction() {
        if (notificationStrategy == null) {
            throw new IllegalStateException("Notification strategy not set.");
        }
        notificationStrategy.sendNotification("Send Notification Strategy");
    }
}