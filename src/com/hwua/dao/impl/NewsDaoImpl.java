package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.INewsDao;
import com.hwua.entity.News;
import com.hwua.tools.JDBCUtils;

public class NewsDaoImpl implements INewsDao {

	@Override
	public List<News> queryNewsList() throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql="SELECT * FROM HWUA_NEWS";
		List<News> list = run.query(sql, new BeanListHandler<>(News.class));
		
		
		return list;
	}

	@Override
	public News queryOneNews(int id) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql="SELECT * FROM HWUA_NEWS WHERE HN_ID = ?";
		News result = run.query(sql, new BeanHandler<>(News.class),id);
		return result;
	}

}
