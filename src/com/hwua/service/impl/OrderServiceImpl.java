package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.ICartDao;
import com.hwua.dao.IGoodsDao;
import com.hwua.dao.IOrderDao;
import com.hwua.dao.impl.CartDaoImpl;
import com.hwua.dao.impl.GoodsDaoImpl;
import com.hwua.dao.impl.OrderDaoImpl;
import com.hwua.entity.Cart;
import com.hwua.entity.Goods;
import com.hwua.entity.Order;
import com.hwua.entity.Orderdetail;
import com.hwua.service.IOrderService;
import com.hwua.tools.JDBCUtils;

public class OrderServiceImpl implements IOrderService {
	
	@Override
	public int addOrder(Order order,int[] pid, int[] count,int sum) {
		IOrderDao iod = new OrderDaoImpl();
		IGoodsDao igd = new GoodsDaoImpl();
		ICartDao icd = new CartDaoImpl();
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
			try {
				//1开启事务
				JDBCUtils.beginTransaction();
				//1.1 查询该用户是否有购物车
				Cart cart = icd.queryCart(order.getHo_user_id());
				if(cart != null){
					//1.2删除该用户的购物车
					result3 = icd.deleteCart(order.getHo_user_id());
					//1.3 更改商品的库存,根据id修改库存,修改的值为int[]count的值
					for(int i = 0; i < pid.length;i++){
						result2 = igd.updateStockById(pid[i],count[i]);
					}
					//1.4 生成一个订单
					result1 = iod.insertOrder(order,sum);
				}else{
					return result1;
				}
				//2.提交事务
				JDBCUtils.commitTransaction();
			} catch (SQLException e) {
				try {
					//3.执行失败后回滚
					JDBCUtils.rollbackTransaction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		
		return result1+result2+result3;
		
	}
	
	@Override
	public Order showOrder(int uid) {
		IOrderDao iod = new OrderDaoImpl();
		Order ord = null;
		try {
			ord = iod.showOrderByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ord;
	}

	@Override
	public int insertOrderDetail(int ho_id, int[] pid, int[] count, int[] sumPrice) {
		IOrderDao iod = new OrderDaoImpl();
		int result = -1 ;
			try {
				for(int i = 0 ; i < pid.length; i++ ){
					//循环添加到数据库订单详情
					result = iod.addOrderDetail(ho_id,pid[i],count[i],sumPrice[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return result;
	}

	@Override
	public List<Orderdetail> showOrderDetail(int oid) {
		IOrderDao iod = new OrderDaoImpl();
		ICartDao icd = new CartDaoImpl();
		List<Orderdetail> list = null;
		try {
			list = iod.queryOrderDetail(oid);
			if(list != null){
				for (int i = 0; i < list.size(); i++) {
					Goods goods = icd.queryById(list.get(i).getHp_id());
					list.get(i).setGoods(goods);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
