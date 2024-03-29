package com.giftVoucher.EntityValidationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.giftVoucher.entity.GiftVoucherOrderDetails;
import com.giftVoucher.model.Buyer;
import com.giftVoucher.model.Gift;
import com.giftVoucher.model.Recipient;
import com.giftVoucher.UtilTestClass.MasterData;

public class EntityValidationTest 
{
    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    // Testing Gift Order success or failed
    @Test
    public void testGiftOrdersSuccess() {
    	GiftVoucherOrderDetails details = MasterData.getDetails();
        Set<ConstraintViolation<GiftVoucherOrderDetails>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testGiftOrderFailed() {
    	GiftVoucherOrderDetails details = MasterData.getDetails();
    	details.setPhoneNumber(null);
        Set<ConstraintViolation<GiftVoucherOrderDetails>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testGiftOrderFailed1() {
    	GiftVoucherOrderDetails details = MasterData.getDetails();
    	details.setGiftAmount(-100L);
        Set<ConstraintViolation<GiftVoucherOrderDetails>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    // Testing 
    @Test
    public void testBuyerSuccess() {
    	Buyer buyer = MasterData.getBuyerDetails();
        Set<ConstraintViolation<Buyer>> violations = validator.validate(buyer);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testBuyerFailed() {
    	Buyer buyer = MasterData.getBuyerDetails();
    	buyer.setBuyerEmailId(null);
        Set<ConstraintViolation<Buyer>> violations = validator.validate(buyer);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testUserFailed1() {
    	Buyer buyer = MasterData.getBuyerDetails();
    	buyer.setBuyerName(null);
        Set<ConstraintViolation<Buyer>> violations = validator.validate(buyer);
        assertFalse(violations.isEmpty());
    }
    
    @Test
	public void testBuyerNameLength() {
    	Buyer buyer = MasterData.getBuyerDetails();
    	buyer.getBuyerName();
		int maxChar = 5;
		boolean usernameLength = ((buyer.getBuyerName().length()) >= maxChar);
		assertEquals(usernameLength, true);
	}
    @Test
    public void testPincodeNumber() {
    	Recipient recipient = MasterData.getRecipientDetails();
    	recipient.getPincode();
    	int pin = 6;
    	boolean pincode = ((recipient.getPincode().length()) == pin);
    	assertEquals(pincode, true);
    }
    @Test
    public void testGiftNameLength() {
    	Gift gift = MasterData.getGiftDetails();
    	gift.getGiftName();
    	int maxChar = 5;
    	boolean usernameLength = ((gift.getGiftName().length()) >= maxChar);
    	assertEquals(usernameLength, true);
    }
    @Test
    public void testRecipientNameLength() {
    	Recipient recipient = MasterData.getRecipientDetails();
    	recipient.getRecipientUserName();
    	int maxChar = 5;
    	boolean usernameLength = ((recipient.getRecipientUserName().length()) >= maxChar);
    	assertEquals(usernameLength, true);
    }
    
    @Test
	public void testPasswordLength() {
    	Buyer buyer = MasterData.getBuyerDetails();
		buyer.getPassword();
		int passwordLength = 10;
		assertEquals(passwordLength, buyer.getPassword().length());
	}
    @Test
    public void testRecipientMobileNo() {
    	Recipient recipient = MasterData.getRecipientDetails();
    	recipient.getRecipientPhoneNo();
    	int passwordLength = 10;
    	assertEquals(passwordLength, recipient.getRecipientPhoneNo().length());
    }    
}