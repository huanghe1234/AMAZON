package com.hwua.service;

import com.hwua.entity.User;

public interface IUserService {
	/**
	 * 注册用户的逻辑
	 * @param u 用户对象
	 * @return 1成功 其他失败
	 */
	int insertUser(User u);
	/**
	 * 根据输入的用户名查看是否重复的逻辑
	 * @param checkName
	 * @return 成功返回用户对象  失败null
	 */
	User checkName(String checkName);
	/**
	 * 根据输入的邮箱查看是否重复的逻辑
	 * @param emailCheck
	 * @return 成功返回用户对象 失败返回null
	 */
	User checkEmail(String emailCheck);
	/**
	 * 用户登录的逻辑
	 * @param uLogin 用户对象
	 * @return 成功返回用户对象  失败返回null
	 */
	User loginUser(User uLogin);
	/**
	 * 找回密码的逻辑
	 * @param u 用户对象
	 * @return 成功返回用户对象 失败null
	 */
	User queryUser(User u);

}
