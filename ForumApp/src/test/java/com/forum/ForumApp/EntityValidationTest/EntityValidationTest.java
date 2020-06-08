package com.forum.ForumApp.EntityValidationTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.forum.ForumApp.UtilTestClass.MasterData;
import com.forum.ForumApp.entity.Posts;

public class EntityValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testPostSuccess() 
    {
    	Posts posts = MasterData.getPostDetails();
        Set<ConstraintViolation<Posts>> violations = validator.validate(posts);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testPostFailed() 
    {
    	Posts posts = MasterData.getPostDetails();
    	posts.setPostDescription(null);
        Set<ConstraintViolation<Posts>> violations = validator.validate(posts);
        assertFalse(violations.isEmpty());
    }
}