package com.karthik.topic.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.karthik.topic.model.Topic;

/*
 * By default all Services are singletons
 * 
 */
@Service
public interface TopicService {

	public List<Topic> getTopics() ;
	public Topic getTopicById(String id);
	public void addTopic(Topic topic);
	public void updateTopic(Topic topic, String id);
	public void deleteTopic(Topic topic, String id);
	public List<Topic> getAllTopicsSimpleJdbc() 
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public List<Topic> getAllTopicsSpringJdbc();

}
