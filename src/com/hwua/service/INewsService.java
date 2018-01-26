package com.hwua.service;

import java.util.List;

import com.hwua.entity.News;

public interface INewsService {
	/**
	 * 从数据库中提取数据的逻辑
	 * @return 成功返回新闻集合 失败为null
	 */
	List<News> getNewsList();
	/**
	 * 查询单个新闻的逻辑
	 * @param nid 
	 * @return 成功返回新闻对象  失败返回null
	 */
	News getOneNews(String nid);

}
