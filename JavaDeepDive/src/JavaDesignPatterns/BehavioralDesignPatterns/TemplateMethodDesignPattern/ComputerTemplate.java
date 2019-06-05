package JavaDesignPatterns.BehavioralDesignPatterns.TemplateMethodDesignPattern;

abstract class ComputerTemplate {

    final void buildComputer(){
        buildMotherBoard();
        buildParts();
        installOS();
        buildAccessories();
        System.out.println("The Computer has been built\n");
    }

    private void buildMotherBoard() {
        System.out.println("Building Motherboard");
    }

    private void buildParts() {
        System.out.println("Building Keyboards, Screens, and Casings");
    }

    abstract void installOS();

    abstract void buildAccessories();
}
