package chainOfResponsability;

public class AssitantManager implements Approver{

    Approver nextApprover;

    @Override
    public void approvePurchase(double amount) {
        if (amount >= 1000 && amount < 2000) {
            System.out.println("Purchase approved by Assistant Manager");
        } else if (nextApprover != null) {
            nextApprover.approvePurchase(amount);
        }
    }

    @Override
    public void setNextApprover(Approver next) {
        this.nextApprover = next;
    }
}
