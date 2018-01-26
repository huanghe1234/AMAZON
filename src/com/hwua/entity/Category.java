package com.hwua.entity;

public class Category {
	 
	  private int HPC_ID;
	  private String HPC_NAME;
	  private int HPC_PARENT_ID;
	  
	public int getHPC_ID() {
		return HPC_ID;
	}
	public void setHPC_ID(int hPC_ID) {
		HPC_ID = hPC_ID;
	}
	public String getHPC_NAME() {
		return HPC_NAME;
	}
	public void setHPC_NAME(String hPC_NAME) {
		HPC_NAME = hPC_NAME;
	}
	public int getHPC_PARENT_ID() {
		return HPC_PARENT_ID;
	}
	public void setHPC_PARENT_ID(int hPC_PARENT_ID) {
		HPC_PARENT_ID = hPC_PARENT_ID;
	}
	public Category(int hPC_ID, String hPC_NAME, int hPC_PARENT_ID) {
		super();
		HPC_ID = hPC_ID;
		HPC_NAME = hPC_NAME;
		HPC_PARENT_ID = hPC_PARENT_ID;
	}
	public Category(String hPC_NAME, int hPC_PARENT_ID) {
		super();
		HPC_NAME = hPC_NAME;
		HPC_PARENT_ID = hPC_PARENT_ID;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [HPC_ID=" + HPC_ID + ", HPC_NAME=" + HPC_NAME + ", HPC_PARENT_ID=" + HPC_PARENT_ID + "]";
	}
	  
	  
}
