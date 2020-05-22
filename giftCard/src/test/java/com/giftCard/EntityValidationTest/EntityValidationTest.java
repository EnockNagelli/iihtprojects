package com.giftCard.EntityValidationTest;
/**
 * @author krishnarjun.pampana
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.giftCard.UtilTestClass.MasterData;
import com.giftCard.entity.GiftCardOrderDetails;

public class EntityValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testGiftOrdersSuccess() {
    	GiftCardOrderDetails details = MasterData.getDetails();
        Set<ConstraintViolation<GiftCardOrderDetails>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testGiftOrderFailed() {
    	GiftCardOrderDetails details = MasterData.getDetails();
    	details.setPhoneNumber(null);
        Set<ConstraintViolation<GiftCardOrderDetails>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testGiftOrderFailed1() {
    	GiftCardOrderDetails details = MasterData.getDetails();
    	details.setGiftAmount(-100L);
        Set<ConstraintViolation<GiftCardOrderDetails>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
}