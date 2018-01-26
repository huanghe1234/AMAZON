package com.hwua.service;

import java.util.List;

import com.hwua.entity.Order;
import com.hwua.entity.Orderdetail;

public interface IOrderService {
	/**
	 * 生成一个订单的逻辑
	 * @param order 订单对象
	 * @param count 购买的数量
	 * @param pid 商品id
	 * @param sum 商品的总额
	 * @return 成功1 其他失败
	 */
	int addOrder(Order order, int[] pid, int[] count, int sum);
	/**
	 * 根据用户id查询订单的逻辑
	 * @param uid 用户id
	 * @return 成功返回order对象 失败null
	 */
	Order showOrder(int uid);
	/**
	 * 根据商品id生成多个订单详情
	 * @param ho_id 订单id
	 * @param pid 商品id
	 * @param count 商品数量
	 * @param sumPrice 商品总价格
	 * @return
	 */
	int insertOrderDetail(int ho_id, int[] pid, int[] count, int[] sumPrice);
	/**
	 * 查询所有订单详情的方法
	 * @param oid 订单id
	 * @return 成功返回Orderdetail对象 失败null
	 */
	List<Orderdetail> showOrderDetail(int oid);
	

}
