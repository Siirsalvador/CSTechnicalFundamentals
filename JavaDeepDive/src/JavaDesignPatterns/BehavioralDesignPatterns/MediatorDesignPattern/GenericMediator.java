package JavaDesignPatterns.BehavioralDesignPatterns.MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class GenericMediator implements AirTrafficMediator {

    private List<Airline> airlines;

    GenericMediator() {
        this.airlines = new ArrayList<>();
    }

    void addAirline(Airline airline){
        this.airlines.add(airline);
    }

    List<Airline> getAirlines(){
        return airlines;
    }

    @Override
    public void sendMessage(String msg, Airline airline) {
        for(Airline aAirline : airlines){
            if(!aAirline.equals(airline)){
                aAirline.receive(msg);
            }
        }
    }
}
