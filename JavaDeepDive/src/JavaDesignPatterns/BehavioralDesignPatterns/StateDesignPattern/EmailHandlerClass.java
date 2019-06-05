package JavaDesignPatterns.BehavioralDesignPatterns.StateDesignPattern;

public class EmailHandlerClass {

    public static void main(String[] args){

        WorkContext workContext = new WorkContext();

        workContext.setState(new HolidayState());
        workContext.replyCustomerEmail();

        workContext.setState(new NoHolidayState());
        workContext.replyCustomerEmail();
    }
}
