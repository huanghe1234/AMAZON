package com.hwua.entity;

public class Orderdetail {
	  
	private int hod_id;
	private int ho_id;
	private int hp_id;
	private int hod_quantity;
	private int hod_cost;
	private Goods goods;
	public int getHod_id() {
		return hod_id;
	}
	public void setHod_id(int hod_id) {
		this.hod_id = hod_id;
	}
	public int getHo_id() {
		return ho_id;
	}
	public void setHo_id(int ho_id) {
		this.ho_id = ho_id;
	}
	public int getHp_id() {
		return hp_id;
	}
	public void setHp_id(int hp_id) {
		this.hp_id = hp_id;
	}
	public int getHod_quantity() {
		return hod_quantity;
	}
	public void setHod_quantity(int hod_quantity) {
		this.hod_quantity = hod_quantity;
	}
	public int getHod_cost() {
		return hod_cost;
	}
	public void setHod_cost(int hod_cost) {
		this.hod_cost = hod_cost;
	}
		
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Orderdetail(int ho_id, int hp_id, int hod_quantity, int hod_cost) {
		super();
		this.ho_id = ho_id;
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}
	public Orderdetail() {
		super();
	}
	@Override
	public String toString() {
		return "Orderdetail [hod_id=" + hod_id + ", ho_id=" + ho_id + ", hp_id=" + hp_id + ", hod_quantity="
				+ hod_quantity + ", hod_cost=" + hod_cost + "]";
	}
	
	
	
	
}
