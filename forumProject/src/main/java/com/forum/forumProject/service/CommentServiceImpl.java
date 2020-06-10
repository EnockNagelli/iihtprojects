package com.forum.forumProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forumProject.dao.CommentsDao;
import com.forum.forumProject.entity.Comments;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentsDao commentsDao;

	@Override
	public Boolean saveComment(Comments comments) {
		commentsDao.saveComment(comments);
		return true;
	}

	@Override
	public List<Comments> getAllComments() {
		return commentsDao.getAllComments();
	}
}