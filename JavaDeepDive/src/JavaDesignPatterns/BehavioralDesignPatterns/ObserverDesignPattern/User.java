package JavaDesignPatterns.BehavioralDesignPatterns.ObserverDesignPattern;

public class User implements Subscriber {


    private String name;
    private Channel channel;

    User(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {

        if (msg == null) {
            System.out.println(String.format("%s has received no update \n", this.name));
        } else {
            System.out.println(String.format("The following message has just been received: %s \n", msg));
        }

    }

    void getUpdate(){
        String msg = this.channel.getUpdate();

        if(msg == null)
            update(null);
    }

    @Override
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
