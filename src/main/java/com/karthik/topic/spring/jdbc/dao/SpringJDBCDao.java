package com.karthik.topic.spring.jdbc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthik.topic.model.Topic;
import com.karthik.topic.simple.jdbc.dao.SimpleJDBCDao;

@Repository
public interface SpringJDBCDao {

	List<Topic> getAllTopicsSpringJdbc();
	Topic getTopicSpringJDBCById(String id);
	void addSpringJDBCTopic(Topic topic);
	void updateSpringJDBCTopic(Topic topic, String id);
	void deleteSpringJDBCTopic(String id);
	void addSpringNamedJDBCTopic(Topic topic);

}
