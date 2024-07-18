package chainOfResponsability;

public class Supervisor implements Approver{
    private Approver nextApprover;

    @Override
    public void approvePurchase(double amount) {
        if (amount >= 500 && amount < 1000) {
            System.out.println("Purchase approved by Supervisor");
        } else if (nextApprover != null) {
            nextApprover.approvePurchase(amount);
        }
    }

    @Override
    public void setNextApprover(Approver next) {
        this.nextApprover = next;
    }
}
