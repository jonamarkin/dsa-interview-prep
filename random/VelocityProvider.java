package random;

import java.time.Duration;


public interface VelocityProvider {


    int getCardUsageCount(Payment payment, Duration duration);

    void registerPayment(Payment payment);

    static random.VelocityProvider getProvider() {
        return Solution.VelocityProviderImpl.INSTANCE;
    }
}
