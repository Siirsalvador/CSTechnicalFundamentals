package JavaDesignPatterns.BehavioralDesignPatterns.TemplateMethodDesignPattern;

public class Windows extends ComputerTemplate {


    @Override
    void installOS() {
        System.out.println("Installing Windows 7");
    }

    @Override
    void buildAccessories() {
        System.out.println("Building Windows Chargers");
    }
}
