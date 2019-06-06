package JavaDesignPatterns.BehavioralDesignPatterns.ObserverDesignPattern;

public class PublishClient {

    public static void main(String[] args) {

        TwitterChannel twitterChannel = new TwitterChannel();

        User user = new User("Ayomide");
        user.setChannel(twitterChannel);
        user.getUpdate();

        twitterChannel.addSubscriber(user);
        twitterChannel.addSubscriber(new User("Okpetere"));
        twitterChannel.addSubscriber(new Database("ChannelDB"));

        twitterChannel.postMessage("Gbemi-Sagay clan just posted a picture");
    }
}
