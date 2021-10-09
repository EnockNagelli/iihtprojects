package com.iiht.forum.utils;

import java.util.ArrayList;
import java.util.List;

import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.model.VisitorComments;
import com.iiht.forum.model.VisitorPosts;

public class ForumUtility {
	
	//=================================================================================================================================
	//				1. Visitor Comment Conversion : Model to DTO - AND - DTO to Model
	//=================================================================================================================================
	public static VisitorComments convertToVisitorComments(VisitorCommentsDto visitorCommentsDto)	{
		
		VisitorComments newVisitorComment = new VisitorComments();

		newVisitorComment.setCommentId(visitorCommentsDto.getCommentId());
		newVisitorComment.setPostId(visitorCommentsDto.getPostId());
		newVisitorComment.setTags(visitorCommentsDto.getTags());
		newVisitorComment.setVisitorComment(visitorCommentsDto.getVisitorComment());

        return newVisitorComment;	
	};
	//---------------------------------------------------------------------------------------------------------------------------------
	public static VisitorCommentsDto convertToVisitorCommentsDTO(VisitorComments visitorComments)	{
		
		VisitorCommentsDto newVisitorCommentDto = new VisitorCommentsDto();

		newVisitorCommentDto.setCommentId(visitorComments.getCommentId());
		newVisitorCommentDto.setPostId(visitorComments.getPostId());
		newVisitorCommentDto.setTags(visitorComments.getTags());
		newVisitorCommentDto.setVisitorComment(visitorComments.getVisitorComment());

        return newVisitorCommentDto;		
	};
	
	//=================================================================================================================================
	//				2. Post Details Conversion : Model to DTO - AND - DTO to Model
	//=================================================================================================================================
	public static VisitorPosts convertToVisitorPosts(VisitorPostsDto visitorPostsDto)	{
		
		VisitorPosts newVisitorPosts = new VisitorPosts();
		
		newVisitorPosts.setPostId(visitorPostsDto.getPostId());
		newVisitorPosts.setTitle(visitorPostsDto.getTitle());
		newVisitorPosts.setTags(visitorPostsDto.getTags());
		newVisitorPosts.setPostDescription(visitorPostsDto.getPostDescription());

		return newVisitorPosts;
	};	
	//---------------------------------------------------------------------------------------------------------------------------------
	public static VisitorPostsDto convertToVisitorPostsDTO(VisitorPosts visitorPosts)	{
		
		VisitorPostsDto newVisitorPostsDto = new VisitorPostsDto();
		
		newVisitorPostsDto.setPostId(visitorPosts.getPostId());
		newVisitorPostsDto.setTitle(visitorPosts.getTitle());
		newVisitorPostsDto.setTags(visitorPosts.getTags());
		newVisitorPostsDto.setPostDescription(visitorPosts.getPostDescription());
		
		return newVisitorPostsDto;
	};

	//=================================================================================================================================
	//				3. Visitor Comment List Conversion : Model to DTO - AND - DTO to Model
	//=================================================================================================================================
    public static List<VisitorCommentsDto> convertToVisitorCommentsDtoList(List<VisitorComments> visitorCommentsList) {
    	
        List<VisitorCommentsDto> list = new ArrayList<VisitorCommentsDto>();
        
        for(VisitorComments companyDto: visitorCommentsList) {
            list.add(convertToVisitorCommentsDTO(companyDto));
        }       
        return list;
    }
	//---------------------------------------------------------------------------------------------------------------------------------
    public static List<VisitorPostsDto> convertToVisitorPostsDtoList(List<VisitorPosts> visitorPostsList) {
    	
		List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
		
		for(VisitorPosts stockDto : visitorPostsList) {
			list.add(convertToVisitorPostsDTO(stockDto));
		}
		return list;
    }
}