package com.hwua.service;

import java.util.List;

import com.hwua.entity.Cart;

public interface ICartService {
	/**
	 * 添加到购物车的逻辑
	 * @param cart 购物车对象
	 * @return
	 */
	int addCart(Cart cart);
	/**
	 * 查看购物车的逻辑
	 * @param uid 用户id
	 * @return
	 */
	List<Cart> showCart(int uid);
	/**
	 * 根据购物车id删除该购物车的逻辑
	 * @param cid
	 * @return
	 */
	int deleteCart(int cid);
	/**
	 * 根据购物车id修改该商品的数量
	 * @param cid 购物车id
	 * @param count 商品数量
	 * @return
	 */
	int changeCount(int cid, int count);
	/**
	 * 判断是否超库存的方法
	 * @param hu_user_id 用户id
	 * @return true购物车没有超过库存  false超过库存
	 */
	boolean getCart(int hu_user_id);

}
