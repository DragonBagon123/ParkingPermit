package parking_permit;

import java.math.BigDecimal;

public class CarpoolDiscount implements RateModifer {
    @Override
    public BigDecimal apply(BigDecimal currentMonthly) {
        return currentMonthly.multiply(new BigDecimal("0.90")); 
    }
}