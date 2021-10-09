package com.iiht.forum.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.exception.PostNotFoundException;
import com.iiht.forum.model.VisitorPosts;
import com.iiht.forum.repository.PostRepository;
import com.iiht.forum.utils.ForumUtility;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostRepository postRepository; 

	public VisitorPostsDto saveUpdate(VisitorPostsDto postDtoInput) 
	{
		VisitorPosts newVisitorPosts = ForumUtility.convertToVisitorPosts(postDtoInput);
		
		postRepository.save(newVisitorPosts);
		
		return postDtoInput;
	}

	public VisitorPostsDto deletePostById(Long postId) 
	{
		Integer value = postRepository.deletePostById(postId);
		
		if(value != null)
			return getPostById(postId);
		else
			throw new PostNotFoundException("No Visitor Post Found in the Database...");
	}

	public VisitorPostsDto getPostById(Long postId) 
	{
		VisitorPosts visitorPosts = postRepository.findVisitorPostById(postId);

		return ForumUtility.convertToVisitorPostsDTO(visitorPosts);
	}

	public List<VisitorPostsDto> getAllPosts() 
	{
		List<VisitorPosts> visitorPostsList = postRepository.findAll();
		
		return ForumUtility.convertToVisitorPostsDtoList(visitorPostsList);
	}

	public Map<Long, String> getAllDiscussions() {
		return null;
	}
}