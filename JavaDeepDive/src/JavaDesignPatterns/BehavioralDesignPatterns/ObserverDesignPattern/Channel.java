package JavaDesignPatterns.BehavioralDesignPatterns.ObserverDesignPattern;

/**
 * a.k.a the Subject
 */
public interface Channel {

    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notifyObservers();

    void postMessage(String msg);

    void addSubscriber(Subscriber subscriber);

    String getUpdate();
}
