package parking_permit;
import java.math.BigDecimal;
public enum VehicleType implements RateModifer {
CAR{
	public BigDecimal apply(BigDecimal price) {
        return price;
    }
},
SUV{
	public BigDecimal apply(BigDecimal price) {
        return price.multiply(new BigDecimal("1.15"));
	}
},MOTORCYCLE{
	public BigDecimal apply(BigDecimal price) {
        return price.multiply(new BigDecimal("0.70"));
	
		}

	}
}













