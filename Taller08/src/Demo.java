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

public class Demo {
    public static void main(String[] args) {
        // Configuración del sistema de notificaciones (Observer)
        NotificationSystem notificationSystem = new NotificationSystem();
        Observer customer1 = new Customer("Alice");
        Observer customer2 = new Customer("Bob");
        Observer customer3 = new Customer("Charlie");

        notificationSystem.registerObserver(customer1);
        notificationSystem.registerObserver(customer2);
        notificationSystem.registerObserver(customer3);

        // Configuración de la cadena de responsabilidad (Chain of Responsibility)
        Approver supervisor = new Supervisor();
        Approver assistantManager = new AssistantManager();
        Approver manager = new Manager();

        supervisor.setNextApprover(assistantManager);
        assistantManager.setNextApprover(manager);

        // Configuración de las estrategias de notificación (Strategy)
        Notifications notifications = new Notifications();

        // Ejemplo de uso del sistema
        double[] purchaseAmounts = {450, 750, 1500, 2500};

        for (double amount : purchaseAmounts) {
            System.out.println("Requesting approval for purchase amount: " + amount);
            supervisor.approvePurchase(amount);

            // Notificar al cliente sobre la compra
            notifications.setNotificationStrategy(new OrkutNotification());
            notifications.notifyAction();
            System.out.println();
        }

        // Generar una nueva promoción y notificar a los clientes
        notificationSystem.newPromotion("50% off on all clothing items!");
        System.out.println();

        // Cambiar la estrategia de notificación y notificar sobre otra compra
        notifications.setNotificationStrategy(new FacebookNotification());
        notifications.notifyAction();
    }
}