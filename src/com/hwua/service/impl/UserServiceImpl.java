package com.hwua.service.impl;

import java.sql.SQLException;

import com.hwua.dao.IUserDao;
import com.hwua.dao.impl.UserDaoImpl;
import com.hwua.entity.User;
import com.hwua.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public int insertUser(User u) {
	IUserDao iud = new UserDaoImpl();	
		if(u==null){
			throw new RuntimeException("传入参数有误");
		}
		//判断用户是否存在
		int row = -1;
			try {
				User result = iud.checkByName(u.getHu_user_name());
				if(result==null){
					//将用户插入数据库
				row = iud.insertUser(u);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return row;
	}

	@Override
	public User checkName(String checkName) {
		IUserDao iud = new UserDaoImpl();
		User u=null;
		try {
			u = iud.checkByName(checkName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User checkEmail(String email) {
		IUserDao iud = new UserDaoImpl();
		User u = null;
		try {
			u = iud.checkByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	@Override
	public User loginUser(User uLogin) {
		if(uLogin==null){
			throw new RuntimeException("传入参数有误");
		}
		IUserDao iud = new UserDaoImpl();
		User loginResult = null;
			try {
				loginResult =iud.login(uLogin);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return loginResult;
	}

	@Override
	public User queryUser(User u) {
		IUserDao iud = new UserDaoImpl();
		User user = null;
		try {
			user = iud.queryUserRetrieve(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


}
