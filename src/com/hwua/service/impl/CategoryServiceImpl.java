package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.ICategoryDao;
import com.hwua.dao.impl.CategoryDaoImpl;
import com.hwua.entity.Category;
import com.hwua.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public List<Category> getParentCate() {
		ICategoryDao icd = new CategoryDaoImpl();
		List<Category> list=null;
		try {
			list = icd.QueryCategoryParent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Category> getChildCate(Category catePra) {
		ICategoryDao icd = new CategoryDaoImpl();
		List<Category> list=null;
		try {
			list = icd.QueryCategoryChild(catePra);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
