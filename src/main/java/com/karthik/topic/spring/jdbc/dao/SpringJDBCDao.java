package com.karthik.topic.spring.jdbc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthik.topic.model.Topic;

@Repository
public interface SpringJDBCDao {

	List<Topic> getAllTopicsSpringJdbc();

}
