package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Comment;

public interface ICommentDao {
	/**
	 * 插入数据库一条评论
	 * @param com 评论对象
	 * @return 1成功  0 失败
	 */
	int insertComment(Comment com)throws SQLException;
	/**
	 * 查询数据库的所有评论
	 * @param end 
	 * @param start 
	 * @return 成功评论集合  失败null 
	 */
	List<Comment> queryComment(int start, int end)throws SQLException;
	/**
	 * 获得总的评论记录数
	 * @return
	 */
	int queryCount() throws SQLException;

}
