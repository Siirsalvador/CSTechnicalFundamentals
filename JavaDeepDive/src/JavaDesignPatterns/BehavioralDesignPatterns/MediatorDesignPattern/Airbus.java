package JavaDesignPatterns.BehavioralDesignPatterns.MediatorDesignPattern;

public class Airbus extends Airline {

    Airbus(AirTrafficMediator trafficMediator, String name) {
        super(trafficMediator, name);
    }

    @Override
    public void send(String msg) {

    }

    @Override
    public void receive(String msg) {
        System.out.println(String.format("The message: %s is being treated by %s", msg, name));
    }
}
