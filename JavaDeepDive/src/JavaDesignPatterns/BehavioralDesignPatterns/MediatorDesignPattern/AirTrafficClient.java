package JavaDesignPatterns.BehavioralDesignPatterns.MediatorDesignPattern;

public class AirTrafficClient {

    public static void main(String[] args) {
        GenericMediator trafficMediator = new GenericMediator();

        trafficMediator.addAirline(new Boeing(trafficMediator, "Boeing737"));
        trafficMediator.addAirline(new Boeing(trafficMediator, "Boeing747"));
        trafficMediator.addAirline(new Airbus(trafficMediator, "AirbusA318"));
        trafficMediator.addAirline(new Airbus(trafficMediator, "AirbusA380"));

        trafficMediator.getAirlines().get(0).send("Testing Connection");
    }
}
