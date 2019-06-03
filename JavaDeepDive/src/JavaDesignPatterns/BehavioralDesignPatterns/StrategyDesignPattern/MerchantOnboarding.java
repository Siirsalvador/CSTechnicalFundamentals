package JavaDesignPatterns.BehavioralDesignPatterns.StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MerchantOnboarding {
    public static void main(String[] args) {

        List<Merchant> merchantList = new ArrayList<>();
        merchantList.add(new Merchant("Moshood Alani Ltd.", "malani@gmail.com", "09023487122"));
        merchantList.add(new Merchant("Test Merchant", "testmerch@tmech.com", "00000019090"));

        Merchants merchants = new Merchants(merchantList);
        merchants.onboardMerchants(new POSOnboardingStrategy());
        merchants.onboardMerchants(new WebOnboardingStrategy());
        merchants.onboardMerchants(new QROnboardingStrategy());
    }
}
