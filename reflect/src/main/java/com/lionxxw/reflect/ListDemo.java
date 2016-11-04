package com.lionxxw.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**		
 * <p>Title: ListDemo </p>
 * <p>Description: 类描述:证明集合的泛型只是在编译时有效,反射可以绕过集合的泛型,编译之后的集合是去泛型化的</p>
 * <p>Copyright (c) 2015 </p>
 * @author xiang_wang	
 * @date 2015年12月4日下午1:53:34
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class ListDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list.add(1);
		list.add("ss");
		for (int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
		list2.add("abc");
//		list2.add(12);
		Class<? extends ArrayList> cls = list2.getClass();
		try {
			Method method = cls.getMethod("add", Object.class);
			method.invoke(list2, 12);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list2.size());
		
		
	}
}
