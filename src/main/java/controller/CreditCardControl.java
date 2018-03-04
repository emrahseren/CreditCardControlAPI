package controller;

import model.CreditCard;


/* Nuh Emrah Seren - 5 Jan 2017
 * This class is prepared for control CreditCard 
 * All validations, controlling are working in this class
 */

public class CreditCardControl {


	/*
	 * This is the main method for creditcard control
	 * First controlling creditcard is valid then
	 * Controlling for brend of creditcard
	 */
	public static CreditCard cardControl(CreditCard creditCard) {		
		if(validControl(creditCard))
			brandControl(creditCard);
	
		return creditCard;
	}
	
	
	/*
	 * This method is control the creditcard is valid or not 
	 */
	private static boolean validControl(CreditCard creditCard) {
		
		boolean isValid = false;
		
		if(!creditCard.getCardNumber().isEmpty() ) {
			if(isCardNumberDigitControl(creditCard.getCardNumber()))
				if(creditCard.getCardNumber().length() >= 12 && creditCard.getCardNumber().length() <= 19)
					if(!creditCard.getCardNumber().startsWith("0") && cardLuhnControl(creditCard.getCardNumber()))
						isValid = true;	
		}
		
		if (isValid) 
			creditCard.setValidity("Valid");
		else
			creditCard.setValidity("Invalid");
		
		
		return isValid;
	}
	
	/*
	 * This method is checking the creditcard brands 
	 * 	Visa 			> 400000​ ​-​ ​499999
 		Mastercard		> 222100​ ​-​ ​272099
 						> 510000​ ​-​ ​559999
		Maestro			> 500000​ ​-​ ​509999
						> 560000​ ​-​ ​699999
 		China​ ​Union​ ​Pay	> 620000​ ​-​ ​629999​ ​(takes​ ​priority​ ​over​ ​Maestro)
	 */
	private static CreditCard brandControl(CreditCard creditCard) {
		
		Integer firstSix = Integer.parseInt(String.valueOf(creditCard.getCardNumber()).substring(0, 6));
		
		if(firstSix >= 400000 && firstSix <=499999) 
			creditCard.setBrand("Visa");
		
		else if(firstSix >= 222100 && firstSix <=222100)
			creditCard.setBrand("Mastercard");
		
		else if(firstSix >= 510000 && firstSix <=559999)
			creditCard.setBrand("Mastercard");
		
		else if(firstSix >= 620000 && firstSix <=629999)
			creditCard.setBrand("China Union Pay");
		
		else if(firstSix >= 500000 && firstSix <=509999)
			creditCard.setBrand("Maestro");
		
		else if(firstSix >= 560000 && firstSix <=699999)
			creditCard.setBrand("Maestro");
		
		return creditCard;
		
	}
	
	/*
	 * This method is for check all card number are digits
	 */
	private static boolean isCardNumberDigitControl(String creditCardNumber) {
		boolean isDigit = true;
		char[] creditCardNumberArray = creditCardNumber.toCharArray();
		
		for (int i = 0; i < creditCardNumber.length(); i++) {
			if (!Character.isDigit(creditCardNumberArray[i])) {
				isDigit = false;
				break;
			}
		}
		
		
		/*  This is an other way to get all chars is number or not. But need to check!!!
		try {
			Long.parseLong(creditCardNumber);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			isDigit = false;
		}
		*/
		
		
		return isDigit;
	}
	

	
	/*
	 * This method is for​ ​the ​Luhn​ ​check​ ​digit​ ​is​ ​the​ ​last​ ​digit​ ​of​ ​the​ ​sequence.
	 */
	private static boolean cardLuhnControl(String creditCardNumber)
	{
		 int sum = 0;
	     boolean alternate = false;
	     	for (int i = creditCardNumber.length() - 1; i >= 0; i--)
	     	{
	     		int n = Integer.parseInt(creditCardNumber.substring(i, i + 1));
	     		if (alternate)
	     		{
	     			n *= 2;
	                if (n > 9) 
	                		n = (n % 10) + 1;
	             }
	             sum += n;
	             alternate = !alternate;
	     	}
	        return (sum % 10 == 0);
	 }	 
}
