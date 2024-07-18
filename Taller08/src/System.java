import observer.NotificationSystem;
import observer.Observer;
import observer.Customer;
import chainOfResponsibility.Approver;
import chainOfResponsibility.Supervisor;
import chainOfResponsibility.AssistantManager;
import chainOfResponsibility.Manager;
import strategy.Notifications;
import strategy.OrkutNotification;
import strategy.FacebookNotification;
import strategy.NotificationStrategy;

public class System {

    private NotificationSystem notificationSystem;
    private Approver supervisor;
    private Notifications notifications;

    public System() {
        setupNotificationSystem();
        setupChainOfResponsibility();
        setupNotificationStrategies();
    }

    public static void main(String[] args) {
        System system = new System();
        system.runDemo();
    }

    private void setupNotificationSystem() {
        notificationSystem = new NotificationSystem();
        Observer customer1 = new Customer("Alice");
        Observer customer2 = new Customer("Bob");
        Observer customer3 = new Customer("Charlie");

        notificationSystem.registerObserver(customer1);
        notificationSystem.registerObserver(customer2);
        notificationSystem.registerObserver(customer3);
    }

    private void setupChainOfResponsibility() {
        supervisor = new Supervisor();
        Approver assistantManager = new AssistantManager();
        Approver manager = new Manager();

        supervisor.setNextApprover(assistantManager);
        assistantManager.setNextApprover(manager);
    }

    private void setupNotificationStrategies() {
        notifications = new Notifications();
    }

    private void runDemo() {
        double[] purchaseAmounts = {450, 750, 1500, 2500};

        for (double amount : purchaseAmounts) {
            processPurchase(amount);
        }

        notifyNewPromotion("50% off on all clothing items!");

        changeNotificationStrategy(new FacebookNotification());
        notifications.notifyAction();
    }

    private void processPurchase(double amount) {
        System.out.println("Requesting approval for purchase amount: " + amount);
        supervisor.approvePurchase(amount);

        // Notificar al cliente sobre la compra
        notifications.setNotificationStrategy(new OrkutNotification());
        notifications.notifyAction();
        System.out.println();
    }

    private void notifyNewPromotion(String message) {
        notificationSystem.newPromotion(message);
        System.out.println();
    }

    private void changeNotificationStrategy(NotificationStrategy strategy) {
        notifications.setNotificationStrategy(strategy);
    }
}