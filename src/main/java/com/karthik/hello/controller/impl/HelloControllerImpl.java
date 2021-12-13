package com.karthik.hello.controller.impl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.hello.controller.HelloController;;

@RestController
public class HelloControllerImpl implements HelloController {

	@Override
	@RequestMapping(method=RequestMethod.GET,value="/hello",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String Hello() {
		return "Hello";
	}

}
