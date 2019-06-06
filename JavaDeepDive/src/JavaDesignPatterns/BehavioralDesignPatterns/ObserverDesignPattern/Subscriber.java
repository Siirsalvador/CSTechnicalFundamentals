package JavaDesignPatterns.BehavioralDesignPatterns.ObserverDesignPattern;

/**
 * Subscribers are also called Observers
 */
public interface Subscriber {

    public void update(String msg);

    public void setChannel(Channel channel);
}
