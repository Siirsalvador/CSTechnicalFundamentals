package JavaDesignPatterns.BehavioralDesignPatterns.StrategyDesignPattern;

public class QROnboardingStrategy implements OnboardingDesignStrategy {

    public QROnboardingStrategy() {
    }

    @Override
    public <T> void onboardMerchant(T name) {
        System.out.println(String.format("QR Onboarding Strategy for %s", name));
    }
}

