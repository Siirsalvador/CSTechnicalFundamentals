package JavaDesignPatterns.BehavioralDesignPatterns.StrategyDesignPattern;

public class WebOnboardingStrategy implements OnboardingDesignStrategy {

    public WebOnboardingStrategy() {
    }

    @Override
    public <T> void onboardMerchant(T name) {
        System.out.println(String.format("Web Onboarding Strategy for %s", name));
    }
}
