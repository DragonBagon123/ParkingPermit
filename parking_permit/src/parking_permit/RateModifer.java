package parking_permit;
import java.math.BigDecimal;

public interface RateModifer {

	BigDecimal apply(BigDecimal currentMonthly);
	
}
