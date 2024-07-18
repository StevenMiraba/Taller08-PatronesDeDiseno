package chainOfResponsability;

public class Manager implements Approver{

    Approver nextApprover;

    @Override
    public void approvePurchase(double amount) {
        if (amount >= 2000) {
            System.out.println("Purchase approved by Manager");
        } else if (nextApprover != null) {
            nextApprover.approvePurchase(amount);
        }
    }

    @Override
    public void setNextApprover(Approver next) {
        this.nextApprover = next;
    }

}
