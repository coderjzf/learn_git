package com.jzf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.jzf.model.User;

@Repository
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public static final String SELECT_SQL = "SELECT id,username,password "
			+ "FROM user WHERE id = ?;";
	
	public static final String INSERT_SQL = "INSERT INTO user(username,password) values(?,?);";
	
	public void createUser(User user){
		jdbcTemplate.update(INSERT_SQL, new Object[]{user.getUsername(),user.getPassword()});
	}
	
	public User selectUserById(int id) {
		final User user = new User();
		jdbcTemplate.query(SELECT_SQL, new Object[] { id }, new RowCallbackHandler() {

			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		});
		return user;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
