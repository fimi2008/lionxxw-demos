package com.lionxxw.cart.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Items implements Serializable{
	private static final long serialVersionUID = 1735400396722683079L;

	@Setter
	@Getter
	private Integer id;		// id
	
	@Setter
	@Getter
	private String name;	// 商品名称
	
	@Setter
	@Getter
	private String factory;	// 产地
	
	@Setter
	@Getter
	private Double price;	// 价格
	
	@Setter
	@Getter
	private Integer inNum;	// 库存
	
	@Setter
	@Getter
	private String pic; 	// 图片
	
	public Items() {
		super();
	}

	public Items(Integer id, String name, String factory, Double price,
			Integer inNum, String pic) {
		super();
		this.id = id;
		this.name = name;
		this.factory = factory;
		this.price = price;
		this.inNum = inNum;
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "商品编号:"+id + " 商品名称:"+name + " ";
	}

	/**
	 * 保证购物车不添加重复的商品,重写商品类的equals()和hashCode()方法
	 */
	@Override
	public int hashCode() {
		return this.getId() + this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj instanceof Items){
			Items i = (Items)obj;
			if (this.getId() == i.getId() && this.getName().equals(i.getName())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}	
}