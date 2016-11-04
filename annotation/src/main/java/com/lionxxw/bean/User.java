package com.lionxxw.bean;

import lombok.Getter;
import lombok.Setter;

import com.lionxxw.annotation.Column;
import com.lionxxw.annotation.Table;

/**		
 * <p>Title: User </p>
 * <p>Description: 类描述:用户类</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: </p>
 * @author xiang_wang	
 * @date 2015年12月4日上午9:17:37
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
@Table("user")
public class User {
	
	@Getter
	@Setter
	@Column("id")
	private Long id;
	
	@Getter
	@Setter
	@Column("name")
	private String name;
	
	@Getter
	@Setter
	@Column("age")
	private Integer age;
	
	@Getter
	@Setter
	@Column("sex")
	private Boolean sex;
	
	@Getter
	@Setter
	@Column(value = "school", isLike = true)
	private String school;
	
	@Getter
	@Setter
	@Column("phone")
	private String phone;
	
	@Getter
	@Setter
	@Column(value = "address" , isLike = true)
	private String address;
}