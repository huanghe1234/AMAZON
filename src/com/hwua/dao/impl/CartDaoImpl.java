package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.ICartDao;
import com.hwua.entity.Cart;
import com.hwua.entity.Goods;
import com.hwua.tools.JDBCUtils;

public class CartDaoImpl implements ICartDao {

	@Override
	public Cart checkCartId(int pid,int uid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_CART  WHERE PID = ? AND USERID = ?";
		Cart cart = run.query(sql, new BeanHandler<>(Cart.class),pid,uid);
		return cart;	
	}

	@Override
	public int insertCart(Cart cart) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "INSERT INTO HWUA_CART VALUES(SEQ_HWUA_CART.NEXTVAL,?,?,?)";
		int result1 = run.update(sql,cart.getPid(),cart.getQuantity(),cart.getUserid());
		return result1;
	}

	@Override
	public int getCount(int pid,int uid) throws SQLException {
		int count = -1;
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT QUANTITY FROM  HWUA_CART WHERE PID = ? AND USERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, pid);
		ps.setObject(2, uid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		conn.close();	
		return count;
	}
	
	@Override
	public int updateCart(int pcount,int pid,int uid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "UPDATE HWUA_CART SET QUANTITY = ? WHERE PID = ? AND USERID= ?";
		int result2 = run.update(sql,pcount,pid,uid);
		return result2;
	}

	@Override
	public List<Cart> getAll(int uid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_CART WHERE USERID = ?";
		List<Cart> list = run.query(sql, new BeanListHandler<>(Cart.class),uid);
		return list;
	}

	@Override
	public Goods queryById(int pid) throws SQLException{
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_PRODUCT WHERE HP_ID = ?";
		Goods goods = run.query(sql, new BeanHandler<>(Goods.class),pid);
		return goods;
	}

	@Override
	public int deleteCartById(int cid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "DELETE FROM HWUA_CART WHERE ID = ?";
		int result = run.update(sql,cid);
		return result;
	}

	@Override
	public int deleteCart(int uid) throws SQLException {
		QueryRunner run = new QueryRunner();
		String sql = "DELETE FROM HWUA_CART WHERE USERID = ?";
		int update = run.update(JDBCUtils.getConnection(),sql,uid);
		return update;
	}

	@Override
	public int changeCountById(int cid, int count) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "UPDATE HWUA_CART SET QUANTITY =  ? WHERE ID = ?";
		int update = run.update(sql,count,cid);
		return update;
	}

	@Override
	public Cart queryCart(int uid) throws SQLException{
		QueryRunner run = new QueryRunner();
		String sql = "SELECT * FROM HWUA_CART WHERE USERID = ?";
		Cart cart = run.query(JDBCUtils.getConnection(), sql,new BeanHandler<>(Cart.class),uid);
		return cart;
	}

/*	@Override
	public List<Cart> getCartByUid(int uid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM HWUA_PRODUCT WHERE USERID = ?";
		List<Cart> list = run.query(sql, new BeanListHandler<>(Cart.class),uid);
		return list;
	}*/


	

}
