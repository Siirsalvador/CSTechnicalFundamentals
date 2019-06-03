package JavaDesignPatterns.BehavioralDesignPatterns.StrategyDesignPattern;

import java.util.List;

public class Merchants {

    private List<Merchant> merchantList;

    Merchants(List<Merchant> merchants) {
        this.merchantList = merchants;
    }

    void onboardMerchants(OnboardingDesignStrategy onboardingDesignStrategy) {

        for (Merchant merchant : this.merchantList) {
            onboardingDesignStrategy.onboardMerchant(merchant.toString());
        }

    }

}

class Merchant {

    private String name;
    private String email;
    private String phoneNumber;

    Merchant(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

