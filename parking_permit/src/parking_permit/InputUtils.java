package parking_permit;

import java.util.Scanner;

public class InputUtils {
	
public static String getUserInput(Scanner sc, String prompt) {
		System.out.print(prompt);
		return sc.nextLine();
	}

public static String readStringYorN(Scanner sc, String prompt) {
    String input;
    do {
        input = readStringInput(sc, prompt).toUpperCase(); 
        if(!input.equals("Y") && !input.equals("N")) System.out.println("Please enter Y or N.");
    } while(!input.equals("Y") && !input.equals("N"));
    return input;
}

////Checks if user typed any numeric values or special char
public static String readStringInput(Scanner sc, String prompt) 
{
	String value = "";
	do {
			value =  getUserInput(sc, prompt);
		try {

			if(!value.matches("[a-zA-Z]+")) 
			{
				value = "";
				throw new InvalidStringException("Dont use any numbers/speical characters or spacing, please");
			}
			
			
		}
		catch(InvalidStringException e){
			
			System.out.println(e.getMessage());
			
		}

	}while(value.equals(""));
	
	return value;
}


public static double readDoubleInRange (Scanner sc, String prompt,double min,double max) {
		
		Double value = null;
		
	do {
		try {
			String userInput = getUserInput(sc, prompt);
			value = Double.parseDouble(userInput);
			if(value < min || value > max) {
				value = null;
				System.out.println("Error: Value is out of range.");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid Input: Please enter a numeric value.");
		}
		
		}while(value == null);	
	
		return value;
	
	}

	public static int readIntInRange (Scanner sc, String prompt,int min,int max) {
			
		Integer value = null;
		
	do {
		try {
			String userInput = getUserInput(sc, prompt);
			value = Integer.parseInt(userInput);
			if(value < min || value > max) {
				value = null;
				System.out.println("Error: Value is out of range.");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid Input: Please enter a numeric value.");
		}

		}while(value == null);	
	
		return value;
	
	}
	
	public static class InvalidStringException extends Exception {
		private static final long serialVersionUID = 1L;
		public InvalidStringException(String message) {
	        super(message);
	    }
	}

}
