package com.forum.ForumProject.FunctionalTestCases;

import static org.mockito.Mockito.when;

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

import com.forum.ForumProject.UtilTestClass.MasterData;
import com.forum.forumProject.dao.CommentsDao;
import com.forum.forumProject.dao.DiscussionTitleDao;
import com.forum.forumProject.dao.PostDao;
import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.DiscussionTitles;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentServiceImpl;
import com.forum.forumProject.service.DiscussionServiceImpl;
import com.forum.forumProject.service.PostServiceImpl;

public class TestFunctional 
{
	static 
	{
		File file = new File("output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}
	
	@Mock
	private PostDao postDao;
	@Mock
	private CommentsDao commentsDao;
	@Mock
	private DiscussionTitleDao discussionDao;

	@Mock
	private Posts posts;

	@InjectMocks
	private PostServiceImpl postServiceImpl;
	@InjectMocks
	private CommentServiceImpl commentServiceImpl;
	@InjectMocks
	private DiscussionServiceImpl discussionServiceImpl;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSavePosts() throws Exception 
	{
		boolean value = postServiceImpl.savePost(MasterData.getPostDetails());
		File file = new File("output_revised.txt");
	    FileUtils.write(file, "\ntestSavePosts="+(value ? true : false), true); 
	}

	@Test
	public void testSaveComments() throws Exception 
	{
		boolean value = commentServiceImpl.saveComment(MasterData.getCommentDetails());
		File file = new File("output_revised.txt");
	    FileUtils.write(file, "\ntestSaveComments="+(value ? true : false), true); 
	}
	
	/*
	 * @Test public void testSaveDiscussions() throws Exception { boolean value =
	 * discussionServiceImpl.saveDiscussion(MasterData.getCommentDetails()); File
	 * file = new File("output_revised.txt"); FileUtils.write(file,
	 * "\ntestSaveDiscussions="+(value ? true : false), true); }
	 */

	/*
	 * @Test public void testGetPost() throws Exception { Posts posts = new Posts();
	 * posts.setPostId(1); int userId = posts.getPostId(); Posts postfromdb =
	 * postServiceImpl.getPostById(posts.getPostId()); File file = new
	 * File("output_revised.txt"); FileUtils.write(file,
	 * "\ntestGetPost="+(userId==0?true:false), true); }
	 */

	@Test
	public void testViewAllPosts() throws Exception 
	{
		List<Posts> list = new ArrayList<Posts>();
		list.add(new Posts());
		list.add(new Posts());
	    
	    when(postDao.getAllPosts()).thenReturn((List<Posts>) list);
		List<Posts> postFromdb = postServiceImpl.getAllPosts();
		File file = new File("output_revised.txt");
		FileUtils.write(file, "\ntestViewAllPosts="+(postFromdb==list ? true : false), true); 
	}

	@Test
	public void testViewAllComments() throws Exception 
	{
		List<Comments> list = new ArrayList<Comments>();
		list.add(new Comments());
		list.add(new Comments());
	    
	    when(commentsDao.getAllComments()).thenReturn((List<Comments>) list);
		List<Comments> commentFromdb = commentServiceImpl.getAllComments();
		File file = new File("output_revised.txt");
		FileUtils.write(file, "\ntestViewAllComments="+(commentFromdb==list ? true : false), true); 
	}
	
	@Test
	public void testViewAllDiscussions() throws Exception 
	{
		List<DiscussionTitles> list = new ArrayList<DiscussionTitles>();
		list.add(new DiscussionTitles());
		list.add(new DiscussionTitles());
	    
	    when(discussionDao.getAllDiscussionTitles()).thenReturn((List<DiscussionTitles>) list);
		List<DiscussionTitles> discussionFromdb = discussionServiceImpl.getAllDiscussions();
		File file = new File("output_revised.txt");
		FileUtils.write(file, "\ntestViewAllDiscussions="+(discussionFromdb==list ? true : false), true); 
	}
	
	/*
	 * @Test public void testDeletePostById() throws Exception { Boolean value =
	 * postServiceImpl.updatePostById(MasterData.getPostDetails().getPostId(),
	 * posts); File file = new File("output_revised.txt"); FileUtils.write(file,
	 * "\ntestDeletePostById="+(value ? true : false), true); }
	 */
}
