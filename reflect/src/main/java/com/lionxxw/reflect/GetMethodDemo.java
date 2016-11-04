package com.lionxxw.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**		
 * <p>Title: GetMethodDemo </p>
 * <p>Description: 类描述:通过反射调用方法</p>
 * <p>Copyright (c) 2015 </p>
 * @author xiang_wang	
 * @date 2015年12月4日下午1:44:59
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class GetMethodDemo {
	
	public static void main(String[] args) {
		A a = new A();
		Class<? extends A> c = a.getClass();
		try {
			Method method = c.getMethod("print", String.class, String.class);
			Object invoke = method.invoke(a, "aaa", "bbb");
			System.out.println(invoke);
			
			method = c.getMethod("print", int.class, int.class);
			invoke = method.invoke(a, 1, 2);
			System.out.println(invoke);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class A{
	public void print(String a, String b){
		System.out.println(a.toUpperCase() + "|" + b.toLowerCase());
	}
	
	public int print(int a, int b){
		System.out.println(a+b);
		return a+b;
	}
	
}
