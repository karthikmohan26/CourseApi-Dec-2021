package com.karthik.topic.simple.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthik.topic.model.Topic;

@Repository
public interface SimpleJDBCDao {

	List<Topic> getAllTopicsSimpleJdbc() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	
	

}
