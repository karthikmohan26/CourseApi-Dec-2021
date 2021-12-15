package com.karthik.topic.spring.jdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.karthik.constants.DBConstants;
import com.karthik.topic.model.Topic;
import com.karthik.topic.spring.jdbc.dao.SpringJDBCDao;
import com.karthik.topic.spring.jdbc.dao.mapper.TopicMapper;

@Repository
public class SpringJDBCDaoImpl implements SpringJDBCDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	/*Creating the new Jdbc Template instance and assigning the 
	Datasource should happen during initialization of Dao*/
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Topic> getAllTopicsSpringJdbc() {
		return jdbcTemplate.query(DBConstants.LIST_OF_TOPICS, new TopicMapper());

	}

	@Override
	public Topic getTopicSpringJDBCById(String id) {
		return jdbcTemplate.queryForObject(DBConstants.GET_TOPIC_BY_ID, new Object[] {id}, new TopicMapper());
	}

	@Override
	public void addSpringJDBCTopic(Topic topic) {
         jdbcTemplate.update(DBConstants.INSERT_TOPIC, new Object[]{topic.getId(),topic.getName(),topic.getDescription()});	
	}

	@Override
	public void updateSpringJDBCTopic(Topic topic, String id) {
		jdbcTemplate.update(DBConstants.UPDATE_TOPIC, new Object[] {id,topic.getName(),topic.getDescription()});	
	}

	@Override
	public void deleteSpringJDBCTopic(String id) {
		jdbcTemplate.update(DBConstants.DELETE_TOPIC, new Object[] {id});
	}

}
