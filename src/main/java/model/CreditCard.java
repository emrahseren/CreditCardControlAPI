package model;

/* Nuh Emrah Seren - 5 Jan 2017
 * This class is prepared for the credit card 
 * CreditNumber field is contain; CreditCard Number
 * Brand field contains is CardBrand like Visa, Master, Mastero
 * Validity field contain is This card is Valid or Invalid 
 */

public class CreditCard {

    private String cardNumber;
    private String brand;
    private String validity;
    

    public CreditCard(String cardNumber) {
        this.setCardNumber(cardNumber);
        this.setBrand(null);
        this.setValidity(null);
    }
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
}
