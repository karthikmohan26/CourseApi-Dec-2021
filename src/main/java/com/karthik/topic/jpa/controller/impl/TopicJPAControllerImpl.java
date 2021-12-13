package com.karthik.topic.jpa.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.topic.jpa.controller.TopicControllerJPA;
import com.karthik.topic.jpa.model.TopicJPA;
import com.karthik.topic.jpa.service.TopicJPAService;


@RestController
public class TopicJPAControllerImpl implements TopicControllerJPA {

	//Step-1 : Logging using slf4j
	Logger logger = LoggerFactory.getLogger(TopicJPAControllerImpl.class);
	
	@Autowired
	private TopicJPAService topicJPAService;

	@RequestMapping(method=RequestMethod.GET, value="/jpa/topics",
    		produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TopicJPA> getTopics() {
		logger.info("Inside Get All Topics Method");
		return topicJPAService.getAllTopicsJPA();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/jpa/topics" ,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void addTopics(@RequestBody TopicJPA topicJPA) {
		 topicJPAService.addTopicsJPA(topicJPA);
	}

	@RequestMapping(method=RequestMethod.GET, value="/jpa/topics/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	public TopicJPA getTopicById(@PathVariable String id) {
		return topicJPAService.getTopicById(id);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/jpa/topics/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	public void updateTopic(@RequestBody TopicJPA topicJPA, @PathVariable String id) {
		topicJPAService.updateTopic(topicJPA,id);		
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/jpa/topics/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	public void deleteTopic(@RequestBody TopicJPA topicJPA, @PathVariable String id) {
		topicJPAService.deleteTopic(topicJPA,id);
	}
}
