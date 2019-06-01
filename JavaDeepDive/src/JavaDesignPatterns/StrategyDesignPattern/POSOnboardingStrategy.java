package JavaDesignPatterns.StrategyDesignPattern;

public class POSOnboardingStrategy implements OnboardingDesignStrategy {

    public POSOnboardingStrategy() {
    }

    @Override
    public <T> void onboardMerchant(T name) {
        System.out.println(String.format("POS Onboarding Strategy for %s", name));
    }
}
