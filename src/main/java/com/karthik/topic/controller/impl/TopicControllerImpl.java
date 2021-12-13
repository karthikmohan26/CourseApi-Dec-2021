package com.karthik.topic.controller.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.topic.controller.TopicController;
import com.karthik.topic.model.Topic;
import com.karthik.topic.service.TopicService;

@RestController
public class TopicControllerImpl implements TopicController {

	/*
	 * When spring starts and Initiates the Controller it sees this and and finds
	 * that it needs dependency Injection and injects the service here
	 */

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = "/topics", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/topics/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}

	@RequestMapping(method=RequestMethod.POST,value="/topics" , produces=MediaType.APPLICATION_JSON_VALUE)
	public void addTopic(@RequestBody Topic topic) {
	topicService.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateTopic(Topic topic, String id) {
	topicService.updateTopic(topic,id);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteTopic(Topic topic, String id) {
		topicService.deleteTopic(topic,id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/simple/jdbc", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> getAllTopicsSimpleJdbc() 
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return topicService.getAllTopicsSimpleJdbc();
	}

	
	
	

}
