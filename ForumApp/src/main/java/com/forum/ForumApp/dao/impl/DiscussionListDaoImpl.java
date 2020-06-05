package com.forum.ForumApp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.forum.ForumApp.dao.DiscussionListDao;
import com.forum.ForumApp.entity.DiscussionList;

public class DiscussionListDaoImpl implements DiscussionListDao {

    @Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<DiscussionList> showDiscussionList() {
		String hql = "FROM DiscussionList as g ORDER BY g.discussionId";
		return (List<DiscussionList>) hibernateTemplate.find(hql);
	}
}
