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

@Service
public class TopicServiceImpl implements TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Spring", "Spring Desscription"),
			new Topic("2", "SpringBoot", "SpringBoot Description"),
			new Topic("3", "Hibernate", "Hibernate Description")));

    @Autowired
    private SimpleJDBCDao simpleJDBCDao;
	
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

}
