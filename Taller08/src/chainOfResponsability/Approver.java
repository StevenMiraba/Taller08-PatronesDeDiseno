package chainOfResponsability;

public interface Approver {
    void approvePurchase(double amount);
    void setNextApprover(Approver next);
}