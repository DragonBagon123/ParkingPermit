package parking_permit;
import java.math.BigDecimal;
public enum PermitType {
RESIDENT(new BigDecimal("45.00")), 
COMMUTER(new BigDecimal("35.00"));
private BigDecimal cost;
	
	
PermitType(BigDecimal cost){
	
	this.cost = cost;
	
	}

	public BigDecimal getCost(){
		
		return cost;
		
	}

}
