package com.jzf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jzf.domain.User;

@Repository
public class UserDaoImpl {

	private JdbcTemplate jdbcTemplate;

	public static final String CREATE_TABLE_SQL = "CREATE TABLE user"
			+ "(id INT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(20),password VARCHAR(20));";

	public static final String SELECT_SQL = "SELECT id,username,password FROM user WHERE id = ?;";

	public static final String SELECT_WITH_USERNAME_SQL = "SELECT id,"
			+ "username,password FROM user WHERE username = ?;";

	public static final String SELECT_LIST_SQL = "SELECT id,username,password FROM user WHERE id > ?";

	public static final String INSERT_SQL = "INSERT INTO user(username,password) VALUES(?,?);";

	public static final String DELETE_SQL = "DELETE FROM user WHERE id = ?;";

	public static final String UPDATE_SQL = "UPDATE user SET username =? ,password = ? WHERE id = ?";

	// ����
	public void createTable() {
		jdbcTemplate.execute(CREATE_TABLE_SQL);
	}

	// ʹ��RowCallbackHandler��ѯ������¼
	public User selectUserById(int id) {
		User user = new User();
		Object[] params = new Object[] { id };
		jdbcTemplate.query(SELECT_SQL, params, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		});

		return user;
	}

	// ����username��ѯ������¼
	public User selectUserByUserName(String username) {
		User user = new User();
		jdbcTemplate.query(SELECT_WITH_USERNAME_SQL, new Object[] { username }, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		});
		return user;
	}

	// ʹ��RowCallbackHandler��ѯ������¼
	public List<User> selectUsersWithRowCallbackHandler(int id) {
		List<User> users = new ArrayList<>();
		Object[] params = new Object[] { id };
		jdbcTemplate.query(SELECT_LIST_SQL, params, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				users.add(user);
			}
		});

		return users;
	}

	// ʹ��RowMapper��ѯ������¼
	public List<User> selectUsersWithRowMapper(int id) {
		return jdbcTemplate.query(SELECT_LIST_SQL, new Object[] { id }, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				return user;
			}
		});

	}

	// ��ӵ�����¼
	public void addUser(User user) {
		Object[] params = new Object[] { user.getUsername(), user.getPassword() };

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				return preparedStatement;
			}
		}, keyHolder);
		// getKey������ȡ������������
		user.setId(keyHolder.getKey().intValue());
	}

	// ������Ӽ�¼
	public void addUsers(List<User> users) {
		jdbcTemplate.batchUpdate(INSERT_SQL, new BatchPreparedStatementSetter() {

			// Ϊÿ������������ò���
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				User user = users.get(i);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
			}

			// ���������������������
			@Override
			public int getBatchSize() {
				return users.size();
			}
		});
	}

	// ����idɾ��������¼
	public void deleteUserById(int id) {
		jdbcTemplate.update(DELETE_SQL, new Object[] { id }, new int[] { Types.INTEGER });
	}

	// ���µ�����¼
	public void updateUser(User user) {
		Object[] params = new Object[] { user.getUsername(), user.getPassword(), user.getId() };
		jdbcTemplate.update(UPDATE_SQL, params, new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER });
	}

	// �������¼�¼
	public void updateUsers(List<User> users) {
		jdbcTemplate.batchUpdate(UPDATE_SQL, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				User user = users.get(i);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setInt(3, user.getId());
				;
			}

			@Override
			public int getBatchSize() {
				return users.size();
			}
		});
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
