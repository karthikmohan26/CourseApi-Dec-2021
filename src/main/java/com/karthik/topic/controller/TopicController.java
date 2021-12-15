package com.karthik.topic.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.topic.model.Topic;


/*Spring Application during start up performs the class path scan and registers these and
when  the request comes in it knows know what to do */

//Step 6
//Spring MVC Converts into JSON and sends the Request back
@RestController
@RequestMapping("/api")
public interface TopicController {
	
	//Step 7
	/*Web Layer/UI/View Layer in Spring Boot Application --- > Handled by Spring MVC
	 * --> Spring MVC is added by Spring web dependency -->  Build controllers in Spring MVC 
	 * --> Controllers  are Java classes annotated with uri and http Method to a method/functionality 
	 * When a request comes in , it examines the Request and Response and looks for the controllers that 
	 * it has registered during start and if it finds then looks for a method and executes it and sends it back
	 *  
	 */
	@RequestMapping(method=RequestMethod.GET, value="/topics" ,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> getAllTopics();
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{id}", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Topic getTopicById(@PathVariable String id);
	
	@RequestMapping(method=RequestMethod.POST, value="/topics", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void addTopic(@RequestBody Topic topic);
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id);
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteTopic(@RequestBody Topic topic, @PathVariable String id);
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/simple/jdbc", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> getAllTopicsSimpleJdbc() 
			throws InstantiationException, 
			IllegalAccessException, ClassNotFoundException, SQLException ;
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/spring/jdbc", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> getAllTopicsSpringJdbc() ;
	
	@RequestMapping(method=RequestMethod.GET,value="/topics/spring/jdbc/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE) 
	public Topic getTopicSpringJDBCById(@PathVariable String id);
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/spring/jdbc",
			produces=MediaType.APPLICATION_JSON_VALUE) 
	public void addSpringJDBCTopic(@RequestBody Topic topic);
	
	@RequestMapping(method=RequestMethod.PUT, value="topics/spring/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE) 
	public void updateSpringJDBCTopic(@RequestBody Topic topic , @PathVariable String id);
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/spring/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE) 
	public void deleteSpringJDBCTopic(@PathVariable String id);

}
