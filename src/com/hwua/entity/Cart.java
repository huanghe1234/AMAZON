package com.hwua.entity;

public class Cart {

	   private int id ;
	   private int pid;
	   private int quantity;
	   private int userid;
	   private Goods goods;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Cart() {
		super();
	}
	public Cart(int pid, int quantity, int userid) {
		super();
		this.pid = pid;
		this.quantity = quantity;
		this.userid = userid;
	}
	
	public Cart(int pid, int userid, Goods goods) {
		super();
		this.pid = pid;
		this.userid = userid;
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", pid=" + pid + ", quantity=" + quantity + ", userid=" + userid + "]";
	}
	
	   
}
