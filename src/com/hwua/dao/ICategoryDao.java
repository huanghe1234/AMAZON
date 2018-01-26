package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Category;

public interface ICategoryDao {
	/**
	 * 获得左侧列表的父元素
	 * @return 成功列表集合 失败null
	 * @throws SQLException
	 */
	List<Category> QueryCategoryParent() throws SQLException;
	/**
	 * 获得左侧列表子元素
	 * @param catePra 父类列表对象
	 * @return 成功列表集合  失败null
	 */
	List<Category> QueryCategoryChild(Category catePra) throws SQLException;
}
