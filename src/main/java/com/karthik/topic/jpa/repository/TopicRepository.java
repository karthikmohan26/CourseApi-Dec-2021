package com.karthik.topic.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.karthik.topic.jpa.model.TopicJPA;

//Step 5 - Common Methods
public interface TopicRepository extends CrudRepository<TopicJPA, String> {

}
