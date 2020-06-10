package com.forum.ForumProject.EntityValidationTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.DiscussionTitles;
import com.forum.forumProject.entity.Posts;

public class TestEntityValidation {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //----------------------------------------------------------------------------------------------
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

    //----------------------------------------------------------------------------------------------
    @Test
    public void testCommentSuccess() 
    {
    	Comments comments = MasterData.getCommentDetails();
        Set<ConstraintViolation<Comments>> violations = validator.validate(comments);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testCommentFailed() 
    {
    	Comments comments = MasterData.getCommentDetails();
    	comments.setVisitorComment(null);
        Set<ConstraintViolation<Comments>> violations = validator.validate(comments);
        assertFalse(violations.isEmpty());
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testDiscussionSuccess() 
    {
    	DiscussionTitles discussion = MasterData.getDiscussionDetails();
        Set<ConstraintViolation<DiscussionTitles>> violations = validator.validate(discussion);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testDiscussionFailed() 
    {
    	DiscussionTitles discussion = MasterData.getDiscussionDetails();
    	discussion.setDiscussionTitle(null);
        Set<ConstraintViolation<DiscussionTitles>> violations = validator.validate(discussion);
        assertFalse(violations.isEmpty());
    }   
}