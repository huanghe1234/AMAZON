package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.News;

public interface INewsDao {
	/**
	 * 从数据库中获取新闻的列表
	 * @return 成功返回新闻集合  失败返回null
	 */
	List<News> queryNewsList() throws SQLException;
	/**
	 * 获得从数据库得到单个新闻对象
	 * @param id
	 * @return 成功返回新闻对象  失败返回null
	 */
	News queryOneNews(int id) throws SQLException;

}
