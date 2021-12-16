package com.karthik.constants;

public class DBConstants {
	
	public static final String LIST_OF_TOPICS="select * from topicJpa";
	public static final String GET_TOPIC_BY_ID="select * from topicJpa WHERE ID=?";
	public static final String INSERT_TOPIC ="Insert into topicJpa(id,name,description)values(?,?,?)";
	public static final String UPDATE_TOPIC = "Update topicJpa set id=?, name=?, description=? where id=?";
	public static final String DELETE_TOPIC = "DELETE from topicJpa where id=?";
	public static final String INSERT_NAMEDJDBC_TOPIC = "Insert into topicJpa(id,name,description)values(:id,:name,:description)";



}
