package com.lionxxw.cart.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**		
 * <p>Title: Cart </p>
 * <p>Description: 类描述:购物车</p>
 * <p>Copyright (c) 2015 </p>
 * @author xiang_wang	
 * @date 2016年1月5日上午10:46:51
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class Cart implements Serializable{
	
	private static final long serialVersionUID = -7976710721490255539L;

	public Cart() {
		goods = new HashMap<Items, Integer>();
		totalPrice = 0.0;
	}
	
	@Setter
	@Getter
	private HashMap<Items, Integer> goods; // 购买商品集合
	
	@Setter
	@Getter
	private Double totalPrice;				// 购物车的总金额
	
	// 添加商品进购物车
	public boolean addGoods(Items item, int num){
		if (null != item){
			if (goods.containsKey(item)){
				goods.put(item, goods.get(item) + num);
			}else{
				goods.put(item, num);
			}
		}
		calTotalPrice();
		return true;
	}
	
	// 删除商品
	public boolean removeGoods(Items item){
		if (null != item){
			goods.remove(item);
			calTotalPrice();
		}
		return true;
	}
	
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Items> keys = goods.keySet();
		Iterator<Items> iterator = keys.iterator();
		while (iterator.hasNext()){
			Items item = iterator.next();
			sum += item.getPrice() * goods.get(item);
		}
		this.setTotalPrice(sum);
		return sum;
	}
	
	/**
	 * 
	 * 测试购物车功能
	 * @param args
	 * @author xiang_wang
	 * 2016年1月5日上午11:23:52
	 */
	public static void main(String[] args) {
		// 创建商品对象
		Items t1 = new Items(1, "苹果", "美国", 5288.00, 500, "1.jpg");
		Items t2 = new Items(2, "小米", "中国", 1999.00, 500, "2.jpg");
		
		Cart c = new Cart();
		c.addGoods(t1, 1);
		c.addGoods(t2, 2);
		c.addGoods(t1, 3);
		
		// 变量购物商品的集合
		Set<Entry<Items,Integer>> entrySet = c.getGoods().entrySet();
		for (Entry<Items,Integer> obj : entrySet){
			System.out.println(obj);
		}
		
		System.out.println("购物车总金额:"+c.getTotalPrice());
	}
}