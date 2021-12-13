package com.karthik.topic.simple.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.constants.APIConstants;

import com.karthik.topic.model.Topic;
import com.karthik.topic.simple.jdbc.dao.SimpleJDBCDao;

@Repository
public class SimpleJDBCDaoImpl implements SimpleJDBCDao {
	
	
	
	@Override
	public List<Topic> getAllTopicsSimpleJdbc()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		
		
		Connection conn = null;
		List<Topic> topics = new ArrayList<Topic>();
        System.out.println("Inside DAO");
		try {
			
			
			String Driver = APIConstants.DB_DRIVER;
			Class.forName(Driver).newInstance();
		    conn = DriverManager.getConnection(APIConstants.CONNECTION_STRING, APIConstants.USERNAME, APIConstants.PASSWORD);			
	   		PreparedStatement ps = conn.prepareStatement(APIConstants.SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Inside Result Set");
				Topic topic = new Topic();
				topic.setId(rs.getString(APIConstants.ID));
				topic.setDescription(rs.getString(APIConstants.DESCRIPTION));
				topic.setName(rs.getString(APIConstants.NAME));
				topics.add(topic);
			}
			rs.close();
			ps.close();

		} catch (RuntimeException e) {

			e.printStackTrace();
		} finally {

			conn.close();
		}

		return topics;
	}

}
