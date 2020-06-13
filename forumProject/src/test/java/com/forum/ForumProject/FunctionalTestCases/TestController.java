package com.forum.ForumProject.FunctionalTestCases;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
import com.forum.forumProject.entity.DiscussionTitles;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.DiscussionService;
import com.forum.forumProject.service.PostService;
import com.google.gson.Gson;

public class TestController 
{
	@Mock
	private PostService postService;

	@Mock
	private CommentService commentService;

	@Mock
	private DiscussionService discussionService;

	@InjectMocks
	private VisitorController visitorController;

	private MockMvc mockMvc;

	// -------------------------------------------------------------------------------------------------------------------
	static {
		File file = new File("controller_output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("controller_output_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

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

		File file = new File("controller_output_revised.txt");
		FileUtils.write(file,
				"\ntestLoadingPageUrl=" + (result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	// -------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testAddPost() throws Exception 
	{ 
		MvcResult result = this.mockMvc.perform(get("/addNewPost")).andExpect(status().isOk()).andExpect(view().name("addPost")).andReturn();
	    
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestAddPost="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 
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
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSavePosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 		
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
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSavePostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);		
	}

	@Test 
	public void testViewAllPosts() throws Exception 
	{ 
		List<Posts> posts =	new ArrayList<Posts>(); 
		posts.add(new Posts());
		posts.add(new Posts());
		
		when(postService.getAllPosts()).thenReturn((List<Posts>) posts);
		
		MvcResult result = this.mockMvc.perform(get("/viewAllPosts")).andExpect(status().isOk()).andExpect(view().name("viewPosts")).andReturn();

		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllPosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);		
		
		//List<Posts> dataFromdb = postService.getAllPosts();
		//File file1 = new File("controller_output_revised.txt"); 
		//FileUtils.write(file1, "\ntestViewAllPosts="+(dataFromdb==posts? true : false), true); 
	}

	@Test 
	public void testViewAllPostsCase() throws Exception 
	{
		when(postService.getAllPosts()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/viewAllPosts")).andExpect(status().isOk()).andExpect(view().name("visitor")).andReturn(); 
	  
		//System.out.println("----------------------------");
		//System.out.println("RESULT : "+result.getResponse().getContentAsString());
		//System.out.println("----------------------------");
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllPostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}
	  
	//-------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testAddComments() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/addComments")).andExpect(status().isOk()).andExpect(view().name("addComment")).andReturn();
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestAddComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 
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
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSaveComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
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
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSaveCommentsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);	
	}
	  
	//--------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllDiscussions() throws Exception 
	{
		List<DiscussionTitles> discuss = new ArrayList<DiscussionTitles>();
		discuss.add(new DiscussionTitles());
		discuss.add(new DiscussionTitles());
		
		when(discussionService.getAllDiscussions()).thenReturn((List<DiscussionTitles>) discuss);
		
		MvcResult result = this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk()).andExpect(view().name("viewDiscussionList")).andReturn();

		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllDiscussions="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}
	  
	@Test 
	public void testViewAllDiscussionsCase() throws Exception 
	{
		when(discussionService.getAllDiscussions()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk()).andExpect(view().name("visitor")).andReturn(); 
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllDiscussionsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);		
	}	 
}