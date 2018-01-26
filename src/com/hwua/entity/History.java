package com.hwua.entity;

import java.sql.Date;

public class History {
	
	private int id ;
	private int pid;
	private int userid;
	private Date querytime;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getQuerytime() {
		return querytime;
	}
	public void setQuerytime(Date querytime) {
		this.querytime = querytime;
	}
	
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public History() {
		super();
	}
	public History(int pid, int userid, Date querytime) {
		super();
		this.pid = pid;
		this.userid = userid;
		this.querytime = querytime;
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", pid=" + pid + ", userid=" + userid + ", querytime=" + querytime + "]";
	}
	
	
}
