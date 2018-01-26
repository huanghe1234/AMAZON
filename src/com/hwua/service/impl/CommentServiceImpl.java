package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.ICommentDao;
import com.hwua.dao.impl.CommentDaoImpl;
import com.hwua.entity.Comment;
import com.hwua.tools.Pager;
import com.hwua.service.ICommentService;

public class CommentServiceImpl implements ICommentService {

	@Override
	public int addComment(Comment com) {
		ICommentDao icd = new CommentDaoImpl();
		if(com==null){
			throw new RuntimeException("传入参数有误!");
		}
		int result = -1;
		try {
			result = icd.insertComment(com);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Comment> showComment(Pager pager) {
		ICommentDao icd = new CommentDaoImpl();
		List<Comment> list = null;
		try {
			//获得总的记录数
			int count = icd.queryCount();
			//将记录总数设置到pager对象中
			pager.setRecordCount(count);
			int start = (pager.getCurrentPage()-1)*pager.PAGE_RECORD;
			int end = start+pager.PAGE_RECORD;
			//调用dao层,查询区间集合
			list = icd.queryComment(start,end);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
