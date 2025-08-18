package random;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.NavigableSet;
import java.util.concurrent.*;




class Payment {

    private final String cardId;
    private final Instant timestamp;

    public Payment(String cardId, Instant timestamp) {
        if (cardId == null || timestamp == null) {
            throw new IllegalArgumentException("cardId and timestamp cannot be null");
        }
        this.cardId = cardId;
        this.timestamp = timestamp;
    }

    public String getCardId() {
        return cardId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}



public class Solution {



    static class VelocityProviderImpl implements VelocityProvider {

        private final Map<String, NavigableSet<Instant>> cardUsageMap;

        static final VelocityProviderImpl INSTANCE = new VelocityProviderImpl();


        private VelocityProviderImpl() {
            cardUsageMap = new ConcurrentHashMap<>();
        }

        @Override
        public int getCardUsageCount(Payment payment, Duration duration) {
            String cardId = payment.getCardId();
            Instant now = payment.getTimestamp();
            Instant cutoff = now.minus(duration);

            NavigableSet<Instant> timestamps = cardUsageMap.get(cardId);
            if (timestamps == null) return 0;


            return timestamps.tailSet(cutoff, true)
                    .headSet(now, true)
                    .size();
        }


        @Override
        public void registerPayment(Payment payment) {
            String cardId = payment.getCardId();
            Instant timestamp = payment.getTimestamp();

            cardUsageMap
                    .computeIfAbsent(cardId, k -> new ConcurrentSkipListSet<>())
                    .add(timestamp);
        }
    }

}


