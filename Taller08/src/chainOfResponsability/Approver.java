package chainOfResponsability;

public interface Approver {
    void setNextApprover(Approver next);
    void approvePurchase(double amount);
}
