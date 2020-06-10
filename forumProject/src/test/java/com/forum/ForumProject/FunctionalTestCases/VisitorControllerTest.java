package com.forum.ForumProject.FunctionalTestCases;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.controller.VisitorController;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.DiscussionTitles;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.DiscussionService;
import com.forum.forumProject.service.PostService;
import com.google.gson.Gson;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class VisitorControllerTest {

	@Mock
	private PostService postService;

	@Mock
	private CommentService commentService;

	@Mock
	private DiscussionService discussionService;
	
	@InjectMocks
	private VisitorController visitorController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(visitorController).build();
	}

	@Test
	public void testLoadingPageUrl() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
	@Test
	public void testAddPost() throws Exception {
		this.mockMvc.perform(get("/addPost")).andExpect(status().isOk()).andExpect(view().name("ok"));				
	}

	@Test
	public void testAddComments() throws Exception {
		this.mockMvc.perform(get("/addComments")).andExpect(status().isOk()).andExpect(view().name("ok"));				
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSavePosts() throws Exception 
	{
		Gson gson = new Gson();
		when(postService.savePost(MasterData.getPostDetails())).thenReturn(false);
		this.mockMvc
				.perform(post("/savePost").content(gson.toJson(MasterData.getPostDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));
	}

	@Test
	public void testViewAllPosts() throws Exception
	{
		List<Posts> posts = new ArrayList<Posts>();
		posts.add(new Posts());
		when(postService.getAllPosts()).thenReturn((List<Posts>) posts);
		this.mockMvc.perform(get("/viewPosts")).andExpect(status().isOk()).andExpect(view().name("ok"));
	}	
	
	@Test
	public void testViewAllPostsCase1() throws Exception 
	{
		when(postService.getAllPosts()).thenReturn(null);
		this.mockMvc.perform(get("/viewPosts")).andExpect(status().isOk())
				.andExpect(view().name("No Records Found"));
	}

	@Test
	public void testSavePostsTestCase2() throws Exception 
	{
		Gson gson = new Gson();
		when(postService.savePost(MasterData.getPostDetails())).thenReturn(true);
		this.mockMvc
				.perform(post("/addPost").content(gson.toJson(MasterData.getPostDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));

	}
	
	//-------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSaveComments() throws Exception 
	{
		Gson gson = new Gson();
		when(commentService.saveComment(MasterData.getCommentDetails())).thenReturn(false);
		this.mockMvc
				.perform(post("/saveComment").content(gson.toJson(MasterData.getCommentDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));
	}

	//-------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllDiscussions() throws Exception
	{
		List<DiscussionTitles> discuss = new ArrayList<DiscussionTitles>();
		discuss.add(new DiscussionTitles());
		when(discussionService.getAllDiscussions() ).thenReturn((List<DiscussionTitles>) discuss);
		this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk()).andExpect(view().name("ok"));
	}	

	@Test
	public void testViewAllDiscussions1() throws Exception 
	{
		when(discussionService.getAllDiscussions()).thenReturn(null);
		this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk())
				.andExpect(view().name("No Records Found"));
	}	
}