package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.INewsDao;
import com.hwua.dao.impl.NewsDaoImpl;
import com.hwua.entity.News;
import com.hwua.service.INewsService;

public class NewsServiceImpl implements INewsService {

	@Override
	public List<News> getNewsList() {
	INewsDao ind = new NewsDaoImpl();	
	List<News> list = null;
		try {
			list = ind.queryNewsList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public News getOneNews(String nid) {
		int id = 1;
		if(nid != null && !"".equals(nid)){
			id = Integer.parseInt(nid);
		}
		INewsDao ind = new NewsDaoImpl();
		News news = null;
		try {
			news = ind.queryOneNews(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return news;
	}

}
