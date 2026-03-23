package parking_permit;

import java.math.BigDecimal;

public class PricingCalculator {

    public BigDecimal calculateMonthly(PermitType permit, VehicleType vehicle, boolean carpool) {
        BigDecimal base = permit.getCost();
        if (permit == PermitType.COMMUTER) {
            base = base.multiply(new BigDecimal("0.85"));
        }

       PricingPipeline pipeline = new PricingPipeline();
        pipeline.addModifier(vehicle);
        if (carpool) {
            pipeline.addModifier(new CarpoolDiscount());
        }
        return pipeline.applyAll(base);
    }
    public BigDecimal calculateTotal(BigDecimal monthly, int months) {
        BigDecimal subtotal = monthly.multiply(new BigDecimal(months));
        BigDecimal campusFee = subtotal.multiply(new BigDecimal("0.05"));
        return subtotal.add(campusFee);
    }
}