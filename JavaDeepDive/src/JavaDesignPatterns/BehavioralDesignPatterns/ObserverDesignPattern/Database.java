package JavaDesignPatterns.BehavioralDesignPatterns.ObserverDesignPattern;

public class Database implements Subscriber {

    private String dbName;

    Database(String name) {
        this.dbName = name;
    }

    @Override
    public void update(String msg) {

        if(msg == null){
            System.out.println(String.format("Nothing was saved to %s \n", this.dbName));
        }else {
            System.out.println(String.format("The following message has been saved to the database: %s \n", msg));
        }
    }

    @Override
    public void setChannel(Channel channel) {

    }
}
