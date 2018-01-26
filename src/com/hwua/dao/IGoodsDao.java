package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Category;
import com.hwua.entity.Goods;
import com.hwua.entity.Order;

public interface IGoodsDao {
	/**
	 * 查询所有的商品记录数
	 * @return 所有的商品记录数
	 */
	int queryCount() throws SQLException;
	/**
	 * 根据条件查询数据库商品
	 * @param start
	 * @param end
	 * @param id 
	 * @return 成功返回商品类型 失败返回null
	 */
	List<Goods> queryGoods(int start, int end, int id) throws SQLException;
	/**
	 * 从数据库中获得所有商品
	 * @param start
	 * @param end
	 * @return
	 */
	List<Goods> queryGoods(int start, int end) throws SQLException;
	/**
	 * 从数据库中获得单个商品的
	 * @param id 商品id 
	 * @return 成功返回商品对象  失败null
	 */
	Goods getOneGoods(int id) throws SQLException;
	/**
	 * 从数据库中获得大列表商品
	 * @param start
	 * @param end
	 * @param id
	 * @return 成功返回商品集合  失败null
	 */
	List<Goods> queryGoodsParent(int start, int end, int id) throws SQLException;
	/**
	 * 从数据库中获得商品集合,按照库存量从小到大排列
	 * @return 成功返回商品集合  失败null
	 */
	List<Goods> showGoodsHot() throws SQLException;
	/**
	 * 从数据库中获得模糊查询的结果
	 * @param goodsName
	 * @return 成功返回商品集合 失败null
	 */
	List<Goods> showQueryGoods(String goodsName) throws SQLException;
	/**
	 * 根据名字进行模糊查询时的总记录数
	 * @param goodsName
	 * @return
	 */
	int queryCount(String goodsName) throws SQLException;
	/**
	 * 修改对应id商品的库存的方法
	 * @param i 商品id
	 * @param j 购买的数量
	 * @return
	 */
	int updateStockById(int i, int j) throws SQLException;
	/**
	 * 根据父类id查询分类对象
	 * @param hpc_id 父类id
	 * @return
	 */
	Category getParentId(int hpc_id)throws SQLException;
	/**
	 * 根据子类id查询分类对象
	 * @param hpc_child_id
	 * @return
	 */
	Category getChildId(int hpc_child_id)throws SQLException;
	/**
	 * 获得所有小列表记录的查询
	 * @param childId 产品的小类id
	 * @return 成功获得小类列表的总记录数  
	 */
	int queryChildCount(int childId) throws SQLException;
	/**
	 * 获得所有大类列表的查询
	 * @param parentId 产品的大类id
	 * @return 成功获得大类列表的总记录数
	 */
	int queryParentCount(int parentId) throws SQLException;
	

}
