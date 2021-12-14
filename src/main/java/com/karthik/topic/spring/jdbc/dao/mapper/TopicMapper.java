package com.karthik.topic.spring.jdbc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.karthik.constants.APIConstants;
import com.karthik.topic.model.Topic;

public class TopicMapper implements RowMapper<Topic> {

	@Override
	public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {

		Topic topic = new Topic();
		topic.setId(rs.getString(APIConstants.ID));
		topic.setDescription(rs.getString(APIConstants.DESCRIPTION));
		topic.setName(rs.getString(APIConstants.NAME));
		return topic;

	}

}
