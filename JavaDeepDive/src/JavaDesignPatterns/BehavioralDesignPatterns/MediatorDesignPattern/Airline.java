package JavaDesignPatterns.BehavioralDesignPatterns.MediatorDesignPattern;

abstract class Airline {

    AirTrafficMediator trafficComMediator;
    String name;

    Airline(AirTrafficMediator airTrafficMediator, String name) {
        this.trafficComMediator = airTrafficMediator;
        this.name = name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);
}
