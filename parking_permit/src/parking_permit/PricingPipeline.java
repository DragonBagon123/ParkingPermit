package parking_permit;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PricingPipeline {
    private ArrayList<RateModifer> modifiers = new ArrayList<>();

    public void addModifier(RateModifer mod) {
        modifiers.add(mod);
    }

    public BigDecimal applyAll(BigDecimal base) {
        BigDecimal result = base;
        for (RateModifer mod : modifiers) {
            result = mod.apply(result);
        }
        return result;
    }
}