package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Cart;
import com.hwua.entity.Goods;

public interface ICartDao {
	/**
	 * 根据购物车商品id查询商品
	 * @param pid 商品id
	 * @param uid 用户id
	 * @return 成功返回商品对象  失败返回null
	 */
	Cart checkCartId(int pid, int uid) throws SQLException;
	/**
	 * 将购物车对象添加到数据库
	 * @param cart 购物车对象
	 * @return 成功1  失败0
	 */
	int insertCart(Cart cart)throws SQLException;
	/**
	 * 将购物车对象进行更新
	 * @param cart
	 * @return 成功返回1  失败0
	 */
	int updateCart(int pcount,int pid,int uid)throws SQLException;
	/**
	 * 获得当前产品的数量
	 * @param pid
	 * @param uid 
	 * @return
	 */
	int getCount(int pid, int uid)throws SQLException;
	/**
	 * 根据用户id查出所有的商品id
	 * @param uid 用户id
	 * @return 成功返回购物车集合  失败null
	 */
	List<Cart> getAll(int uid) throws SQLException;
	
	/**
	 * 根据商品id查询商品所有字段的方法
	 * @param pid 商品id
	 * @return 成功返回商品对象  失败null
	 */
	Goods queryById(int pid) throws SQLException;
	/**
	 * 根据购物车id删除购物车的方法
	 * @param cid 购物车id
	 * @return 成功返回1  0失败
	 */
	int deleteCartById(int cid) throws SQLException;
	/**
	 * 根据用户id删除购物车的方法
	 * @param ho_user_id 用户id
	 * @return 成功1 其他失败
	 */
	int deleteCart(int ho_user_id) throws SQLException;
	/**
	 * 根据购物车id修改购物车内商品的数量
	 * @param cid 购物车id
	 * @param count 商品数量
	 * @return 
	 */
	int changeCountById(int cid, int count) throws SQLException;
	/**
	 * 根据当前用户获得所有的购物车内容
	 * @param hu_user_id 用户id
	 * @return
	 *//*
	List<Cart> getCartByUid(int hu_user_id) throws SQLException;*/
	/**
	 * 根据用户id查询购物车
	 * @param ho_user_id 用户id
	 * @return
	 */
	Cart queryCart(int ho_user_id) throws SQLException;
	

}
