package JavaDesignPatterns.BehavioralDesignPatterns.StateDesignPattern;

public class HolidayState implements State {
    @Override
    public void replyCustomerEmail() {
        System.out.println("Please check back after the holidays");
    }
}
