package JavaDesignPatterns.BehavioralDesignPatterns.MediatorDesignPattern;

public class Boeing extends Airline {

    Boeing(AirTrafficMediator airTrafficMediator, String name){
        super(airTrafficMediator, name);
    }

    @Override
    public void send(String msg) {
        trafficComMediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(String.format("%s received this message: %s", name, msg ));
    }
}