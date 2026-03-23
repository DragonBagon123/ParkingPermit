package parking_permit;
import java.math.BigDecimal;
import java.util.Scanner;
public class ParkingPermit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String permitInput = InputHelpers.CommuterOrResident(sc);
        String vehicleInput = InputHelpers.vechicleType(sc);
        String carpoolInput = InputHelpers.isCarPooling(sc);
        int months = InputUtils.readIntInRange(sc, "How many months? (1-12): ", 1, 12);

        PermitType permit = PermitType.valueOf(permitInput.toUpperCase());
        VehicleType vehicle = VehicleType.valueOf(vehicleInput.toUpperCase());
        boolean carpool = carpoolInput.equalsIgnoreCase("Y");

        PricingCalculator calculator = new PricingCalculator();
        BigDecimal monthly = calculator.calculateMonthly(permit, vehicle, carpool);
        BigDecimal total = calculator.calculateTotal(monthly, months);
        System.out.println("\nHere is your reciept:");
        System.out.println("Permit: " + permit);
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Carpool: " + (carpool ? "Yes" : "No"));
        System.out.println("Months: " + months);
        System.out.println(String.format("Monthly Price: $%.2f", monthly));
        System.out.println(String.format("Total (with 5%% campus fee): $%.2f", total));
    }
}