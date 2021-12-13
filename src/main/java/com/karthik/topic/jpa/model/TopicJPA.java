package com.karthik.topic.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//Step-5 - Swagger
@ApiModel(description="Contact Details")

//Step-3 --> This tells that this an Entity class
@Entity
public class TopicJPA {
	
	//Step-4 --> Primary Key
	@Id
	private String id;
	//Step-6 -Swagger
	@ApiModelProperty(value=" Unique id")
	private String name;
	private String description;
		
	public TopicJPA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TopicJPA(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
