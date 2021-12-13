package com.karthik.topic.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthik.topic.jpa.model.TopicJPA;

@Service
public interface TopicJPAService {

	public List<TopicJPA> getAllTopicsJPA();
	public void addTopicsJPA(TopicJPA topicJPA);
	public TopicJPA getTopicById(String id);
	public void updateTopic(TopicJPA topicJPA, String id);
	public void deleteTopic(TopicJPA topicJPA, String id);	
	

}
