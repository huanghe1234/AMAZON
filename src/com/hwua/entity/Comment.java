package com.hwua.entity;

import java.sql.Date;

public class Comment {
	  
	  private int hc_id;
	  private String hc_title;
	  private String hc_reply;
	  private String hc_content;
	  private Date hc_create_time;
	  private Date hc_reply_time;
	  private String hc_nick_name;
	  private String hc_state;
	public int getHc_id() {
		return hc_id;
	}
	public void setHc_id(int hc_id) {
		this.hc_id = hc_id;
	}
	public String getHc_reply() {
		return hc_reply;
	}
	
	public String getHc_title() {
		return hc_title;
	}
	public void setHc_title(String hc_title) {
		this.hc_title = hc_title;
	}
	public void setHc_reply(String hc_reply) {
		this.hc_reply = hc_reply;
	}
	public String getHc_content() {
		return hc_content;
	}
	public void setHc_content(String hc_content) {
		this.hc_content = hc_content;
	}
	public Date getHc_create_time() {
		return hc_create_time;
	}
	public void setHc_create_time(Date hc_create_time) {
		this.hc_create_time = hc_create_time;
	}
	public Date getHc_reply_time() {
		return hc_reply_time;
	}
	public void setHc_reply_time(Date hc_reply_time) {
		this.hc_reply_time = hc_reply_time;
	}
	public String getHc_nick_name() {
		return hc_nick_name;
	}
	public void setHc_nick_name(String hc_nick_name) {
		this.hc_nick_name = hc_nick_name;
	}
	public String getHc_state() {
		return hc_state;
	}
	public void setHc_state(String hc_state) {
		this.hc_state = hc_state;
	}
	public Comment() {
		super();
	}
	public Comment(String hc_title, String hc_reply, String hc_content, Date hc_create_time, Date hc_reply_time,
			String hc_nick_name, String hc_state) {
		super();
		this.hc_title = hc_title;
		this.hc_reply = hc_reply;
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_reply_time = hc_reply_time;
		this.hc_nick_name = hc_nick_name;
		this.hc_state = hc_state;
	}
	public Comment(String hc_title, String hc_content, String hc_nick_name) {
		super();
		this.hc_title = hc_title;
		this.hc_content = hc_content;
		this.hc_nick_name = hc_nick_name;
	}
	@Override
	public String toString() {
		return "Comment [hc_id=" + hc_id + ", hc_title=" + hc_title + ", hc_reply=" + hc_reply + ", hc_content="
				+ hc_content + ", hc_create_time=" + hc_create_time + ", hc_reply_time=" + hc_reply_time
				+ ", hc_nick_name=" + hc_nick_name + ", hc_state=" + hc_state + "]";
	}
	
	
	  
	  
}
