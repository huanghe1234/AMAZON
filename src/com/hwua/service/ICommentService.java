package com.hwua.service;

import java.util.List;

import com.hwua.entity.Comment;
import com.hwua.tools.Pager;


public interface ICommentService {
	/**
	 * 添加评论的业务逻辑
	 * @param com 评论对象 
	 * @return 成功1 0失败
	 */
	int addComment(Comment com);
	/**
	 * 查询所有评论的业务逻辑
	 * @param pager 分页对象
	 * @return 成功返回评论集合 失败null
	 */
	List<Comment> showComment(Pager pager);

}
