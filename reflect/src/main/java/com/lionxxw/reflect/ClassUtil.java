package com.lionxxw.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**		
 * <p>Title: ClassUtil </p>
 * <p>Description: 类描述:TODO</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月4日下午1:03:12
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class ClassUtil {

	/**
	 * 打印类的信息,包括类的成员函数,成员变量
	 * @param obj 该对象所属类的信息
	 * @author xiang_wang
	 * 2015年12月4日下午1:03:09
	 */
	public static void printClassMessage(Object obj){
		// 要获取类的信息,首先要获得类的类类型
		Class<? extends Object> c = obj.getClass();	// 传递的是哪个子类的对象,c 就是该子类的类类型
		// 获取类的名称
		System.out.println("类的名称是:"+c.getName());
		
		/**
		 * Method类,方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有的public的函数,包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己声明的方法,不问访问权限
		 */
		Method[] methods = c.getMethods(); //c.getDeclaredMethods();
		StringBuilder sb;
		for (Method method : methods) {
			sb = new StringBuilder();
			// 得到方法的返回值类型的类类型
			Class<?> returnType = method.getReturnType();
			sb.append(returnType.getName()).append(" ");
			// 得到方法的名称
			String methodName = method.getName();
			sb.append(methodName);
			// 获得参数类型--->得到的是参数列表的类型的类类型
			Class<?>[] parameterTypes = method.getParameterTypes();
			sb.append("(");
			if (null != parameterTypes && parameterTypes.length > 0){
				for (Class<?> class1 : parameterTypes) {
					sb.append(class1.getName()).append(",");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(")");
			System.out.println(sb.toString());
		}
		
		printFieldMessage(obj);
	}

	/**
	 * 打印类的成员变量信息
	 * @param obj
	 * @author xiang_wang
	 * 2015年12月4日下午1:29:18
	 */
	public static void printFieldMessage(Object obj) {
		Class<? extends Object> c = obj.getClass();
		
		/**
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有的public的成员变量的信息
		 * getDeclaredFields()方法获取的是该类自己声明的成员变量的信息
		 */
//		Field[] fields = c.getFields();
		Field[] fields = c.getDeclaredFields();
		StringBuilder sb;
		for (Field field : fields) {
			sb = new StringBuilder();
			// 得到成员变量的类型的类类型
			Class<?> type = field.getType();
			sb.append(type.getName());
			// 得到成员变量的名称
			String name = field.getName();
			sb.append(" ").append(name);
			
			System.out.println(sb.toString());
			
		}
	}
	
	
	/**
	 * 打印类的构造函数信息
	 * @param obj
	 * @author xiang_wang
	 * 2015年12月4日下午1:31:35
	 */
	public static void printConMessage(Object obj){
		Class<? extends Object> c = obj.getClass();
		/**
		 * 构造函数也是对象
		 * java.lang.Construction中封装了构造函数的信息
		 * getConstructors()获得所有的public的构造方法
		 * getDeclaredConstructors()得到所有的构造函数
		 */
//		Constructor<?>[] constructors = c.getConstructors();
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		StringBuilder sb;
		for (Constructor<?> constructor : constructors) {
			sb = new StringBuilder();
			sb.append(constructor.getName()).append("(");
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			if (null != parameterTypes && parameterTypes.length > 0){
				for (Class<?> class1 : parameterTypes) {
					sb.append(class1.getName()).append(",");
				}
				sb.deleteCharAt(sb.length() - 1);	
			}
			sb.append(")");
			
			System.out.println(sb.toString());
		}
		
	}
	public static void main(String[] args) {
		String st = "";
//		printClassMessage(st);
//		printFieldMessage(st);
		printConMessage(st);
	}
}
