package com.forum.forumProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.forumProject.dao.DiscussionTitleDao;
import com.forum.forumProject.entity.DiscussionTitles;

@Service
@Transactional
public class DiscussionServiceImpl implements DiscussionService {

	@Autowired
	public DiscussionTitleDao discussionTitleDao; 
	
	@Override
	public List<DiscussionTitles> getAllDiscussions() 
	{		
		return discussionTitleDao.getAllDiscussionTitles();
	}
}
