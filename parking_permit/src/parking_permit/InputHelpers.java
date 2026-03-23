package parking_permit;

import java.util.Scanner;

import parking_permit.InputUtils.InvalidStringException;

public class InputHelpers {

    public static String isCarPooling(Scanner sc) 
    {

    	String carPooling = InputUtils.readStringYorN(sc, "Are you carpooling? (Y/N): ");
    	if(carPooling.equals("Y")) {
    		return carPooling;
    	}
		return carPooling;

    }
	
    public static String vechicleType(Scanner sc){
        
    	String value = "";
    	
    	do {
    	
    		value = InputUtils.readStringInput(sc, "What is your vehicle? (MOTORCYCLE/CAR/SUV): ");
    	
    		if(!value.equalsIgnoreCase("MOTORCYCLE") && !value.equalsIgnoreCase("CAR") && !value.equalsIgnoreCase("SUV")) {
				value = "";
				System.out.println("Only type: MOTORCYCLE, CAR, or SUV. Please");
			}
    	}while(value.equals(""));
    	
    	return value;
    }

    public static String CommuterOrResident(Scanner sc){
    
    	String value = "";
    	
    	do {
    	
    		value = InputUtils.readStringInput(sc, "Permit (RESIDENT/COMMUTER): ");
    		try {
    		if (!value.equalsIgnoreCase("Commuter") && !value.equalsIgnoreCase("Resident")) {
	            value = ""; 
    			throw new InvalidStringException("Only type Commuter or Resident, please.");
	         }

    		}catch(InvalidStringException e){
    			
    			System.out.println(e.getMessage());
    			
    		}
    	}while(value.equals(""));
    	
    	return value;
    }
    
}
    
    

