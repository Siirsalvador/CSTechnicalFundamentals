package JavaDesignPatterns.BehavioralDesignPatterns.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class TwitterChannel implements Channel {

    private final Object MUTEX = new Object();
    private String message;
    private boolean changed;
    private List<Subscriber> subscribers;


    TwitterChannel() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        if (subscriber == null) {
            throw new NullPointerException("Subscriber cannot be null");
        }

        synchronized (MUTEX) {
            if (!subscribers.contains(subscriber))
                subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        if (subscriber == null) {
            throw new NullPointerException("Subscriber cannot be null");
        }

        synchronized (MUTEX) {
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifyObservers() {
        List<Subscriber> currentSubscribers;

        //Synchronization ensures only subscribers at the time of message receipt get the message
        synchronized (MUTEX) {
            if (!changed) {
                return;
            }

            currentSubscribers = new ArrayList<>(this.subscribers);
            this.changed = false;
        }

        for (Subscriber subscriber : currentSubscribers) {
            subscriber.update(this.message);
        }
    }

    @Override
    public void postMessage(String msg) {
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

        if (subscriber == null)
            throw new NullPointerException("Subscriber cannot be null");

        this.subscribers.add(subscriber);
    }

    @Override
    public String getUpdate() {
        return this.message;
    }

    void clearMessage(){
        this.message = null;
    }

}
