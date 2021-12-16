package com.karthik.topic.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthik.topic.model.Topic;
import com.karthik.topic.service.TopicService;
import com.karthik.topic.simple.jdbc.dao.SimpleJDBCDao;
import com.karthik.topic.spring.jdbc.dao.SpringJDBCDao;

@Service
public class TopicServiceImpl implements TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Spring", "Spring Desscription"),
			new Topic("2", "SpringBoot", "SpringBoot Description"),
			new Topic("3", "Hibernate", "Hibernate Description")));

    @Autowired
    private SimpleJDBCDao simpleJDBCDao;
    
    @Autowired
    private SpringJDBCDao springJDBCDao;
	
	@Override
	public List<Topic> getTopics() {
		return topics;
	}

	@Override
	public Topic getTopicById(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	@Override
	public void addTopic(Topic topic) {
		topics.add(topic);

	}

	@Override
	public void updateTopic(Topic topic, String id) {

		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(1, topic);
				return;
			}

		}
	}

	@Override
	public void deleteTopic(Topic topic, String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

	@Override
	public List<Topic> getAllTopicsSimpleJdbc() 
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return simpleJDBCDao.getAllTopicsSimpleJdbc();
	}

	@Override
	public List<Topic> getAllTopicsSpringJdbc() {
		return springJDBCDao.getAllTopicsSpringJdbc();
	}

	@Override
	public Topic getTopicSpringJDBCById(String id) {
		return springJDBCDao.getTopicSpringJDBCById(id);
	}

	@Override
	public void addSpringJDBCTopic(Topic topic) {
		springJDBCDao.addSpringJDBCTopic(topic);		
	}

	@Override
	public void updateSpringJDBCTopic(Topic topic, String id) {
		springJDBCDao.updateSpringJDBCTopic(topic,id);		
		
	}

	@Override
	public void deleteSpringJDBCTopic(String id) {
		springJDBCDao.deleteSpringJDBCTopic(id);		
		
	}

	@Override
	public void addSpringNamedJDBCTopic(Topic topic) {
		springJDBCDao.addSpringNamedJDBCTopic(topic);		
	}

}
