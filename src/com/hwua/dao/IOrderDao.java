package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Order;
import com.hwua.entity.Orderdetail;

public interface IOrderDao {
	/**
	 * 添加到数据库订单方法
	 * @param order 订单对象
	 * @param sum 商品总额
	 * @return
	 */
	int insertOrder(Order order, int sum)throws SQLException;
	/**
	 * 从数据库查询所有的订单的方法
	 * @param uid 用户id
	 * @return 成功订单对象  失败null
	 */
	Order showOrderByUid(int uid) throws SQLException;
	/**
	 * 添加订单详情的逻辑
	 * @param ho_id 订单id
	 * @param pid 商品id
	 * @param count 商品数量
	 * @param sumPrice 商品的价格
	 * @return
	 */
	int addOrderDetail(int ho_id, int pid, int count, int sumPrice) throws SQLException;
	/**
	 * 根据订单号查询订单详情的方法
	 * @param oid 订单号
	 * @return 成功返回订单详情集合  失败null
	 */
	List<Orderdetail> queryOrderDetail(int oid) throws SQLException;

}
