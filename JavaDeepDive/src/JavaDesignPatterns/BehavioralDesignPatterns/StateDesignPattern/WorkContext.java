package JavaDesignPatterns.BehavioralDesignPatterns.StateDesignPattern;

public class WorkContext implements State {

    private State workState;

    public void setState(State workState){
        this.workState = workState;
    }

    public State getState(){
        return this.workState;
    }

    @Override
    public void replyCustomerEmail(){
        this.workState.replyCustomerEmail();
    }
}
