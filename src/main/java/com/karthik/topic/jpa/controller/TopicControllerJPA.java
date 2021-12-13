package com.karthik.topic.jpa.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.topic.jpa.model.TopicJPA;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public interface TopicControllerJPA {
	
	
	@RequestMapping(method=RequestMethod.GET,value="/jpa/topics" ,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get All the Topics",
	notes="Gets the Topic from Database",response=TopicJPA.class)
	public List<TopicJPA> getTopics();

	@RequestMapping(method=RequestMethod.POST,value="/jpa/topics" ,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Saves the Topics",
	notes="Saves the Topic into Database",response=TopicJPA.class)
	public void addTopics(@RequestBody TopicJPA topicJPA);
	
	@RequestMapping(method=RequestMethod.GET, value="/jpa/topics/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Gets the Topic By Id",
	notes="Gets the Topic by Id from Database",response=TopicJPA.class)
	public TopicJPA getTopicById(@PathVariable String id);
	
	@RequestMapping(method=RequestMethod.PUT, value="/jpa/topics/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Update the Topic By Id",
	notes="Updates the Topic by Id into Database",response=TopicJPA.class)
	public void updateTopic(@RequestBody TopicJPA topicJPA ,@PathVariable String id);
	
	@RequestMapping(method=RequestMethod.DELETE, value="/jpa/topics/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Deletes the Topic By Id",
	notes="Deletes the Topic by Id from Database",response=TopicJPA.class)
	public void deleteTopic(@RequestBody TopicJPA topicJPA ,@PathVariable String id);
}
