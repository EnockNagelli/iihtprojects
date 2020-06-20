package com.forum.forumProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.forum.forumProject.entity.Comments;
import com.forum.forumProject.entity.Posts;
import com.forum.forumProject.service.CommentService;
import com.forum.forumProject.service.PostService;

@Controller
public class VisitorController {
	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView visitorPage(HttpServletResponse response) throws IOException {
		System.out.println("Server Started. Inside the controller. Serving upon landing page...");
		return new ModelAndView("visitor", "posts", new Posts());
	}

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/addNewPost", method = RequestMethod.GET)
	public ModelAndView addPost() {
		return new ModelAndView("addPost");
	}

	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
	public String savePost(HttpServletRequest request) {
		String title = request.getParameter("vtitle");
		String tags = request.getParameter("vtags");
		String postDescription = request.getParameter("vpost");

		Posts post = new Posts();
		post.setTitle(title);
		post.setTags(tags);
		post.setPostDescription(postDescription);

		postService.savePost(post);

		return "visitor";
	}

	@RequestMapping(value = "/viewAllPosts", method = RequestMethod.GET)
	public ModelAndView getAllPosts() {
		ModelAndView md = null;
		try {
			List<Posts> postList = postService.getAllPosts();

			if (!CollectionUtils.isEmpty(postList)) {
				md = new ModelAndView("viewPosts", "plist", postList);
			} else {
				md = new ModelAndView("visitor");
				throw new RuntimeException("No Records Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return md;
	}

	// --------------------------------------------------------------------------------------------------------------------
	/*
	 * @RequestMapping(value = "/addComments", method = RequestMethod.GET) public
	 * ModelAndView postComments() { return new ModelAndView("addComment"); }
	 */
	// --------------------------------------------------------------------------------------------------------------------
	//public ModelAndView postComments(@RequestParam("id") int postId)
	//public ModelAndView postComments(@RequestParam(value="id", required=false) int postId)
	//public ModelAndView postComments(HttpServletRequest request)

	@RequestMapping(value = "/addComments", method = RequestMethod.GET) 
	public ModelAndView postComments(@RequestParam("id") int postId, Model model) 
	{
		//System.out.println("Post Id : "+request.getParameter("id"));
		System.out.println("Post Id : "+postId); 
		model.addAttribute("id", postId);
		return new ModelAndView("addComment"); 
	}
	 
	// --------------------------------------------------------------------------------------------------------------------
	/* public ModelAndView postComments(@RequestParam("id") int postId) */
	/*
	 * @RequestMapping(value = "/addComments", method = RequestMethod.GET) public
	 * ModelAndView postComments(HttpServletRequest request) {
	 * System.out.println("Post Id : "+request.getParameter("id")); return new
	 * ModelAndView("addComment", "postid", postId); return new
	 * ModelAndView("addComment"); }
	 */
	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	public String saveComments(HttpServletRequest request) {

		int postId = Integer.parseInt(request.getParameter("vpostId"));
		String visitorComment = request.getParameter("vcomments");
		String tags = request.getParameter("vtags");

		Comments comments = new Comments();

		comments.setPostId(postId);;
		comments.setTags(tags);
		comments.setVisitorComment(visitorComment);

		commentService.saveComment(comments);

		return "visitor";
	}

	// --------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/viewDiscussion", method = RequestMethod.GET)
	public ModelAndView viewAllDiscussionTitles() {
		ModelAndView md = null;
		try {
			List<Posts> discussionList = postService.getAllPosts();

			if (!CollectionUtils.isEmpty(discussionList)) {
				md = new ModelAndView("viewDiscussionList", "discussionlist", discussionList);
			} else {
				md = new ModelAndView("visitor");
				throw new RuntimeException("No Records Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return md;
	}
}