package com.lionxxw.list;

import java.util.ArrayList;
import java.util.List;

import com.lionxxw.reflect.ClassUtil;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		initList();
	}
	
	private static List<String> initList(){
		/**
		 * public class ArrayList<E> extends AbstractList<E>
		 * implements List<E>, RandomAccess, Cloneable, java.io.Serializable
		 * 
		 * 默认构造函数
		 * ArrayList()
		 * capacity是ArrayList的默认容量大小。当由于增加数据导致容量不足时，容量会添加上一次容量大小的一半。
		 * ArrayList(int capacity)
		 * 创建一个包含collection的ArrayList
		 * ArrayList(Collection<? extends E> collection)
		 */
		List<String> list = new ArrayList<String>();
		
		ClassUtil.printConMessage(list);
		ClassUtil.printClassMessage(list);
		ClassUtil.printFieldMessage(list);
		
		list.add("a");
		list.add("b");
		list.add("c");
		print(list);
		
		list.add(1, "e");	// 插入元素
		
		print(list);
		
		list.set(1, "change");	// 修改元素
		print(list);
		
		list.remove(1);			// 删除元素
		print(list);
		
		String temp = list.get(1);
		print(temp);
		return list;
	}
	
	private static void print(Object obj){
		System.out.println(obj);
	}
}