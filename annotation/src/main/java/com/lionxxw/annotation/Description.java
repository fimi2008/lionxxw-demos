package com.lionxxw.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**		
 * <p>Title: Description </p>
 * <p>Description: 类描述:主键的基本知识</p>
 * <p>Copyright (c) 2015 </p>
 * @author xiang_wang	
 * @date 2015年12月4日上午10:51:09
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 * 
 * 注解的作用域
 * @Target {
 * 		CONSTRUCTOR 构造方法的声明
 * 		FIELD		字段的声明
 * 		LOCAL_VARIABLE 局部变量的声明
 * 		METHOD		方法的声明
 * 		PACKAGE		包声明
 * 		PARAMETER	参数声明
 * 		TYPE		类,接口声明
 * }
 * 
 * 注解的生命周期
 * @Retention{
 * 		SOURCE		只在源码显示,编译时会丢弃
 * 		CLASS		编译时会记录到class中,运行时忽略
 * 		RUNTIME		运行时存在,可以通过反射读取
 * }
 * @Inherited 		允许子类继承
 * @Documented		生成javadoc时会包含注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

}
