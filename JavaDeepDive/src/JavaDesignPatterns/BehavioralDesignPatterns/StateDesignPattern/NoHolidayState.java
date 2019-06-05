package JavaDesignPatterns.BehavioralDesignPatterns.StateDesignPattern;

public class NoHolidayState implements State {
    @Override
    public void replyCustomerEmail(){
        System.out.println("Your request is currently being treated, kindly be patient");
    }
}
