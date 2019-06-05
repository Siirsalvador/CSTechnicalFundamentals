package JavaDesignPatterns.BehavioralDesignPatterns.TemplateMethodDesignPattern;

class MacBook extends ComputerTemplate {

    @Override
    void installOS() {
        System.out.println("Install Mojave");
    }

    @Override
     void buildAccessories() {
        System.out.println("Building USB-C Chargers and Headphones");
    }
}
