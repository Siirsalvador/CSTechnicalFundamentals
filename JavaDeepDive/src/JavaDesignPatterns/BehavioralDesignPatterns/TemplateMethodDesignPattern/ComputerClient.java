package JavaDesignPatterns.BehavioralDesignPatterns.TemplateMethodDesignPattern;

public class ComputerClient {

    public static void main(String[] args){
        ComputerTemplate macbook = new MacBook();
        macbook.buildComputer();

        ComputerTemplate windows = new Windows();
        windows.buildComputer();
    }
}
