package com.lionxxw.test;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.lionxxw.annotation.Column;
import com.lionxxw.annotation.Table;
import com.lionxxw.bean.User;

public class Test {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1101L);
		user.setAddress("长寿路1688号");
		user.setAge(24);
		user.setName("Jetty");
		user.setPhone("1586647021");
		user.setSchool("实验小学");
		user.setSex(true);
		System.out.println(query(user));
	}
	
	private static String query(Object obj){
		StringBuilder sb = new StringBuilder();
		// 1.获得到class
		Class<? extends Object> cls = obj.getClass();
		
		// 2.获得到table的名字
		boolean exists = cls.isAnnotationPresent(Table.class);
		if (!exists){
			return null;
		}
		
		Table table = cls.getAnnotation(Table.class);
		
		String tableName = table.value();
		
		sb.append("select * from ").append(tableName).append(" where 1=1");
		
		// 3.获取该对象下所有字段
		Field[] fields = cls.getDeclaredFields();
		
		for (Field field : fields) {
			// 4.判断变量是否定义注解
			if (field.isAnnotationPresent(Column.class)){
				Column column = field.getAnnotation(Column.class);
				String columnName = column.value();
				boolean isLike = column.isLike();
				
				String methodName = "get"+field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
				
				try {
					Method method = cls.getMethod(methodName);
					Object value = method.invoke(obj);
					if (null != value){
						if (value instanceof String){
							sb.append(" and ").append(columnName);
							if (isLike){
								sb.append(" like ");
							}else{
								sb.append(" = ");
							}
							sb.append("'").append(value).append("'");
						}else if (value instanceof Long){
							sb.append(" and ").append(columnName).append(" = ").append(value);
						}else if (value instanceof Integer){
							sb.append(" and ").append(columnName).append(" = ").append(value);
						}else if (value instanceof Boolean){
							if ((Boolean)value){
								sb.append(" and ").append(columnName).append(" = ").append(1);
							}else{
								sb.append(" and ").append(columnName).append(" = ").append(0);
							}
						}
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sb.toString();
	}
}