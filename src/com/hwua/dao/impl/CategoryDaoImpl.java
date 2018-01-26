package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.ICategoryDao;
import com.hwua.entity.Category;
import com.hwua.tools.JDBCUtils;

public class CategoryDaoImpl implements ICategoryDao{
	
	
	public List<Category> QueryCategoryParent() throws SQLException{
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT  * FROM HWUA_PRODUCT_CATEGORY WHERE HPC_ID = HPC_PARENT_ID " ;
		List<Category> list = run.query(sql, new BeanListHandler<>(Category.class));
		return list;
	}

	@Override
	public List<Category> QueryCategoryChild(Category catePra) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT  * FROM HWUA_PRODUCT_CATEGORY WHERE HPC_PARENT_ID != HPC_ID AND HPC_PARENT_ID = ?" ;
		List<Category> list = run.query(sql, new BeanListHandler<>(Category.class),catePra.getHPC_PARENT_ID());
		return list;
	}

	
}
