package com.forum.ForumProject.FunctionalTestCases;

import static com.forum.ForumProject.UtilTestClass.TestUtils.businessTestFile;
import static com.forum.ForumProject.UtilTestClass.TestUtils.currentTest;
import static com.forum.ForumProject.UtilTestClass.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.controller.VisitorController;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.PostService;
import com.google.gson.Gson;

public class TestController 
{
	@Mock
	private PostService postService;

	@Mock
	private CommentService commentService;

	@InjectMocks
	private VisitorController visitorController;

	private MockMvc mockMvc;

	// -------------------------------------------------------------------------------------------------------------------
	/*
	 * static { File file = new File("controller_output_revised.txt"); if
	 * (file.exists()) { try { FileUtils.forceDelete(new
	 * File("controller_output_revised.txt")); } catch (IOException e) { // TODO
	 * Auto-generated catch block // e.printStackTrace(); } } }
	 */
	// -------------------------------------------------------------------------------------------------------------------
	@Before
	public void setup() throws Exception 
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(visitorController).build();
	}

	// -------------------------------------------------------------------------------------------------------------------
	@Test
	public void testLoadingPageUrl() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/")).andExpect(view().name("visitor")).andReturn();

	    yakshaAssert(currentTest(), "\ntestLoadingPageUrl=" + (result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

	    //File file = new File("controller_output_revised.txt");
		//FileUtils.write(file, "\ntestLoadingPageUrl=" + (result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	// -------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testAddPost() throws Exception 
	{ 
		MvcResult result = this.mockMvc.perform(get("/addNewPost")).andExpect(status().isOk()).andExpect(view().name("addPost")).andReturn();
	    
	    yakshaAssert(currentTest(), "\ntestAddPost="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

	    //File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestAddPost="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 
	}

	@Test 
	public void testSavePosts() throws Exception 
	{ 
		Gson gson = new	Gson();
		when(postService.savePost(MasterData.getPostDetails())).thenReturn(false);
	  
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
										.content(gson.toJson(MasterData.getPostDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();	
		
	    yakshaAssert(currentTest(), "\ntestSavePosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

		//File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestSavePosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 		
	}

	@Test 
	public void testSavePostsCase() throws Exception
	{ 
		Gson gson = new	Gson();
		when(postService.savePost(MasterData.getPostDetails())).thenReturn(true);
			
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
										.content(gson.toJson(MasterData.getPostDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

	    yakshaAssert(currentTest(), "\ntestSavePostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);
		
		//File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestSavePostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	@Test 
	public void testViewAllPosts() throws Exception 
	{ 
		List<Posts> posts =	new ArrayList<Posts>(); 
		posts.add(new Posts());
		posts.add(new Posts());
		
		when(postService.getAllPosts()).thenReturn((List<Posts>) posts);
		
		MvcResult result = this.mockMvc.perform(get("/viewAllPosts")).andExpect(status().isOk()).andExpect(view().name("viewPosts")).andReturn();

	    yakshaAssert(currentTest(), "\ntestViewAllPosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

		//File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestViewAllPosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	@Test 
	public void testViewAllPostsCase() throws Exception 
	{
		when(postService.getAllPosts()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/viewAllPosts")).andExpect(status().isOk()).andExpect(view().name("visitor")).andReturn(); 
		
	    yakshaAssert(currentTest(), "\ntestViewAllPostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

		//File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestViewAllPostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}
	  
	//-------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testAddComments() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/addComments")).andExpect(status().isOk()).andExpect(view().name("addComment")).andReturn();
		
	    yakshaAssert(currentTest(), "\ntestAddComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);
		
		//File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestAddComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 
	}
	  
	@Test 
	public void testSaveComments() throws Exception 
	{ 
		Gson gson = new  Gson();
		when(commentService.saveComment(MasterData.getCommentDetails())).thenReturn(false);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveComment")
										.content(gson.toJson(MasterData.getCommentDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		
	    yakshaAssert(currentTest(), "\ntestSaveComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

	    //File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestSaveComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	@Test 
	public void testSaveCommentsCase() throws Exception 
	{ 
		Gson gson = new Gson();
		when(commentService.saveComment(MasterData.getCommentDetails())).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveComment")
										.content(gson.toJson(MasterData.getCommentDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		
	    yakshaAssert(currentTest(), "\ntestSaveCommentsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

		//File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestSaveCommentsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);	
	}
	  
	//--------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllDiscussions() throws Exception 
	{
		List<Posts> discuss = new ArrayList<Posts>();
		discuss.add(new Posts());
		discuss.add(new Posts());
		
		when(postService.getAllPosts()).thenReturn((List<Posts>) discuss);
		
		MvcResult result = this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk()).andExpect(view().name("viewDiscussionList")).andReturn();

	    yakshaAssert(currentTest(), "\ntestViewAllDiscussions="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

		//File file = new File("controller_output_revised.txt"); 
		//FileUtils.write(file, "\ntestViewAllDiscussions="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}
	  
	@Test 
	public void testViewAllDiscussionsCase() throws Exception 
	{
		when(postService.getAllPosts()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk()).andExpect(view().name("visitor")).andReturn(); 
		
	    yakshaAssert(currentTest(), "\ntestViewAllDiscussionsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), businessTestFile);

	    //File file = new File("controller_output_revised.txt");
		//FileUtils.write(file, "\ntestViewAllDiscussionsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}
}