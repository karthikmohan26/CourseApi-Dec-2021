package com.karthik.hello.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*Spring Application during start up performs the class path scan and registers and
 when  the request comes in it knows know what to do */

//Step 6
//Spring MVC Converts into JSON and sends the Request back
@RestController
@RequestMapping("/api")
public interface HelloController {
	
	//Step 7 
	
	/*Web Layer/UI/View Layer in Spring Boot Application --- > Handled by Spring MVC
	 * --> Spring MVC is added by Spring web dependency -->  Build controllers in Spring MVC 
	 * --> Controllers  are Java classes annotated with uri and http Method to a method/functionality 
	 * When a request comes in , it examines the Request and Response and looks for the controllers that 
	 * it has registered during start and if it finds then looks for a method and executes it and sends it back
	 *  
	 */
	
	@RequestMapping(method=RequestMethod.GET,value="/hello",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String Hello() ;

}
