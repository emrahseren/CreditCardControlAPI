package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controller.CreditCardControl;
import model.CreditCard;

/*
 * This API is works for the control credit card 
 * This cardControl method return 3 values; 
 * 		1 - CardNumber 			(Exp : China​ ​Union​ ​Pay)
 * 		2 - CardBrandName 		(Exp: Visa, Mastercard, Maestro, China​ ​Union​ ​Pay)
 * 		3 - CardIsValid or Not 	(Exp: Valid, Invalid)
 */

@RestController
@RequestMapping("/api")
public class CreditCardService {
    private static final Logger logger = LogManager.getLogger(CreditCardService.class);

	
	@RequestMapping("/")
    public String welcome() {
        return "Welcome to Credit Card API.";
    }
	
	@RequestMapping("/card/")
    public String card() {
        return "Welcome to CreditCardControl.";
    }
	
    @RequestMapping(value = "/card/{cardNumber}", method = RequestMethod.GET)
    public ResponseEntity<?> cardControl(@PathVariable("cardNumber") String cardNumber) {
    		logger.info("This is info CreditCard Number : "+ cardNumber);
    		CreditCard creditCard = new CreditCard(cardNumber);
    		
    		if(!cardNumber.isEmpty()) {
        		CreditCardControl.cardControl(creditCard);
    		}
        
    		return new ResponseEntity<CreditCard>(creditCard, HttpStatus.OK);	

    }
 
}
