package com.lionxxw.reflect;

/**		
 * <p>Title: Demo1 </p>
 * <p>Description: 类描述:关于类的介绍,三种Class的实例对象的表示方式</p>
 * <p>Copyright (c) 2015 </p>
 * @author xiang_wang	
 * @date 2015年12月4日上午11:51:27
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class Demo1 {
	public static void main(String[] args) {
		// Foo的实例对象如何表示
		Foo f = new Foo();
		
		/**
		 * Foo这个类 也是一个实例对象,Class类的实例对象,如何表示呢
		 * 任何一个类都是Class的实例对象,这个实例对象有三种表示方式
		 */
		
		// 第一种表示方式:实际告诉我们任何一个类都有一个隐含的静态成员变量class
		Class<Foo> c1 = Foo.class;
		
		// 第二种表达方式 已经知道该类的对象通过getClass()方法
		Class<? extends Foo> c2 = f.getClass();
		
		/**
		 * 官网说明:c1,c2 表示了Foo类的类类型(class type)
		 * 万事万物皆对象,类也是对象,是Class类的实例对象
		 * 这个对象我们称为该类的类类型
		 */
		
		// 不管c1 or c2 都代表了Foo类的类类型,一个类只可能是Class类的一个实例对象
		System.out.println(c1 == c2);
		
		// 第三种表达方式
		Class<?> c3 = null;
		try {
			c3 = Class.forName("com.lionxxw.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c3 == c2);
		
		// 我们完全可以通过类的类类型创建该类的对象实例--->通过c1,c2,c3创建Foo的实例
		try {
			Foo foo = (Foo)c1.newInstance();
			foo.print();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
