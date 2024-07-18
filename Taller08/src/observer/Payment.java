package observer;

public class Payment {
    public double amount;
    private NotificationStrategy notification;

    public boolean pay(double amount){
        if(amount!=0){
            return True;
        }
        else{
            return False;
        }
    }

    public void setNotificationStrategy(NotificationStrategy not){
        //code
    }

    public void processPayment(double amount){
        //code
    }


}
