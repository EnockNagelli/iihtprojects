package com.iiht.forum.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.exception.CommentNotFoundException;
import com.iiht.forum.model.VisitorComments;
import com.iiht.forum.repository.CommentRepository;
import com.iiht.forum.utils.ForumUtility;

@Service
@Transactional
public class CommentService 
{
	@Autowired
	private CommentRepository commentRepo; 
	
	public VisitorCommentsDto saveUpdate(VisitorCommentsDto commentDtoInput) 
	{
		System.out.println("Serice called");
		VisitorComments newVisitorComments = ForumUtility.convertToVisitorComments(commentDtoInput);
	
		commentRepo.save(newVisitorComments);
		
		return commentDtoInput;
	}

	public VisitorCommentsDto deleteCommentById(Long postId) 
	{
		Integer value = commentRepo.deleteCommentById(postId);
		
		if(value != null)
			return getCommentById(postId);
		else
			throw new CommentNotFoundException("No Visitor Comment Found in the Database...");
	}

	public VisitorCommentsDto getCommentById(Long postId) 
	{
		VisitorComments visitorComments = commentRepo.findVisitorCommentsById(postId);

		return ForumUtility.convertToVisitorCommentsDTO(visitorComments);
	}

	public List<VisitorCommentsDto> getAllComments() 
	{
		List<VisitorComments> visitorCommentsList = commentRepo.findAll();
		
		return ForumUtility.convertToVisitorCommentsDtoList(visitorCommentsList);
	}
}