package com.karthik.topic.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthik.topic.jpa.model.TopicJPA;
import com.karthik.topic.jpa.repository.TopicRepository;
import com.karthik.topic.jpa.service.TopicJPAService;

@Service
public class TopicJPAServiceImpl implements TopicJPAService {

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<TopicJPA> getAllTopicsJPA() {
		List<TopicJPA> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	
	public void addTopicsJPA(TopicJPA topicJPA) {
		topicRepository.save(topicJPA);
	}


	@Override
	public TopicJPA getTopicById(String id) {
        return topicRepository.findOne(id);		
	}


	@Override
	public void updateTopic(TopicJPA topicJPA, String id) {
		topicRepository.save(topicJPA);
		
	}


	@Override
	public void deleteTopic(TopicJPA topicJPA, String id) {
		topicRepository.delete(id);
	}
}
