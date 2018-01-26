package com.hwua.service;

import java.util.List;

import com.hwua.entity.Category;

public interface ICategoryService {
	/**
	 * 获得小列表的逻辑
	 * @param category 
	 * @return 成功返回列表集合 失败返回null
	 */
	List<Category> getChildCate(Category category);
	/**
	 * 获得大列表的逻辑
	 * @return 成功返回列表集合  失败返回null
	 */
	List<Category> getParentCate();

}
