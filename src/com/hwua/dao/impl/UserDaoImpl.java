package com.hwua.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hwua.dao.IUserDao;
import com.hwua.entity.User;
import com.hwua.tools.JDBCUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public User checkByName(String userName) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_USER WHERE HU_USER_NAME = ?";
		User u = run.query(sql, new BeanHandler<>(User.class),userName);
		return u;
	}

	@Override
	public int insertUser(User u) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "INSERT INTO HWUA_USER VALUES(SEQ_USER.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		int row = run.update(sql, u.getHu_user_name(),u.getHu_password(),u.getHu_sex(),u.getHu_birthday(),u.getHu_identity_code(),u.getHu_email(),u.getHu_mobile(),u.getHu_address(),1);
		return row;
	}

	@Override
	public User login(User uLogin) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_USER WHERE HU_USER_NAME = ? AND HU_PASSWORD= ?";
		User u = run.query(sql, new BeanHandler<>(User.class),uLogin.getHu_user_name(),uLogin.getHu_password());
		return u;
	}

	@Override
	public User checkByEmail(String email) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_USER WHERE HU_EMAIL  = ?";
		User u = run.query(sql, new BeanHandler<>(User.class),email);
		return u;
		
	}

	@Override
	public User queryUserRetrieve(User u) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_USER WHERE  HU_USER_NAME = ? AND HU_IDENTITY_CODE = ? AND HU_EMAIL = ?";
		User user = run.query(sql, new BeanHandler<>(User.class),u.getHu_user_name(),u.getHu_identity_code(),u.getHu_email());
		return user;
	}

}
