package com.hwua.service;

import java.util.List;

import com.hwua.entity.Goods;
import com.hwua.entity.History;
import com.hwua.entity.Order;
import com.hwua.entity.Pager;

public interface IGoodsService {
	/**
	 * 根据id查询小列表商品的逻辑
	 * @param pager
	 * @param hpcid 小列表的商品id
	 * @return 成功返回商品集合 失败返回null
	 */
	List<Goods> getGoods(Pager pager, String hpcid);
	/**
	 * 根据id获得大列表的商品集合
	 * @param pager
	 * @param hpcid 大列表的商品id
	 * @return 成功返回商品集合 失败返回null
	 */
	List<Goods> getGoodsParent(Pager pager, String hpcid);
	/**
	 * 获得所有商品的逻辑
	 * @param pager
	 * @return 成功返回商品对象  失败null
	 */
	List<Goods> getGoods(Pager pager);
	/**
	 * 获得单个商品的逻辑
	 * @param pid
	 * @return 成功返回商品对象  失败null
	 */
	Goods getOne(String pid);
	/**
	 * 获得热销商品的逻辑 
	 * @return 成功返回商品集合  失败返回null
	 */
	List<Goods> getGoodsHot();
	/**
	 * 搜索栏模糊查询商品的逻辑
	 * @param goodsName 商品名称
	 * @return 成功返回商品集合  失败返回null
	 */
	List<Goods> getQueryGoods(String goodsName);
	/**
	 * 将用户点击过的商品id放入数据库中
	 * @param pid 商品id 
	 * @param uid 用户id
	 * @return 成功返回1  失败其他
	 */
	int addHistory(String pid, int uid);
	/**
	 * 根据用户id查询所有商品逻辑
	 * @param uid 用户id 
	 * @return 成功返回商品集合 失败null
	 */
	List<History> showHistory(int uid);
	
	

}
