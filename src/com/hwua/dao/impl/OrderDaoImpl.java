package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.IOrderDao;
import com.hwua.entity.Order;
import com.hwua.entity.Orderdetail;
import com.hwua.tools.JDBCUtils;

public class OrderDaoImpl implements IOrderDao {
	
	@Override
	public int insertOrder(Order order,int sum) throws SQLException {
		QueryRunner run = new QueryRunner();
		String sql = "INSERT INTO HWUA_ORDER VALUES(SEQ_ORDER.NEXTVAL,?,?,?,SYSDATE,?,1,1)";
		int update = run.update(JDBCUtils.getConnection(),sql,order.getHo_user_id(),order.getHo_user_name(),order.getHo_user_address(),sum);
		return update;
	}
	
	@Override
	public Order showOrderByUid(int uid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_ORDER WHERE HO_USER_ID = ? ORDER BY HO_CREATE_TIME DESC";
		Order ord = run.query(sql,new BeanHandler<>(Order.class),uid);
		return ord;
	}

	@Override
	public int addOrderDetail(int ho_id, int pid, int count, int sumPrice) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "INSERT INTO HWUA_ORDER_DETAIL VALUES(SEQ_DETAIL.NEXTVAL,?,?,?,?)";
		int update = run.update(sql,ho_id,pid,count,sumPrice);
		return update;
	}

	@Override
	public List<Orderdetail> queryOrderDetail(int oid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_ORDER_DETAIL WHERE HO_ID = ?";
		List<Orderdetail> odetail = run.query(sql, new BeanListHandler<>(Orderdetail.class),oid);
		return odetail;
	}

}
