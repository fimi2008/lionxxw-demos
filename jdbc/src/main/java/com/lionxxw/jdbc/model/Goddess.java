package com.lionxxw.jdbc.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**		
 * <p>Title: Goddess </p>
 * <p>Description: 类描述:女神表</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月30日下午4:55:20
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class Goddess implements Serializable{

	public Goddess() {
		super();
	}

	public Goddess(Integer id, String userName, Integer sex, Integer age,
			Date birthday, String email, String mobile, String createUser,
			Date createDate, String updateUser, Date updateDate, Integer isdel) {
		super();
		this.id = id;
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.email = email;
		this.mobile = mobile;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.isdel = isdel;
	}

	private static final long serialVersionUID = -8553140585873003008L;
	
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String userName;		// 姓名
	
	@Getter
	@Setter
	private Integer sex;			// 性别(0-男,1-女)
	
	@Getter
	@Setter
	private Integer age;			// 年龄
	
	@Getter
	@Setter
	private Date birthday;			// 生日
	
	@Getter
	@Setter
	private String email;			// 邮箱
	
	@Getter
	@Setter
	private String mobile;			// 手机号码
	
	@Getter
	@Setter
	private String createUser;		// 创建用户
	
	@Getter
	@Setter
	private Date createDate;		// 创建时间
	
	@Getter
	@Setter
	private String updateUser;		// 更新用户
	
	@Getter
	@Setter
	private Date updateDate;		// 更新时间
	
	@Getter
	@Setter
	private Integer isdel;			// 是否删除(0-否,1-是)
	
	
	@Override
	public String toString() {
		return "Goddess [id=" + id + ", userName=" + userName + ", sex=" + sex
				+ ", age=" + age + ", birthday=" + birthday + ", email="
				+ email + ", mobile=" + mobile + ", createUser=" + createUser
				+ ", createDate=" + createDate + ", updateUser=" + updateUser
				+ ", updateDate=" + updateDate + ", isdel=" + isdel + "]";
	}
}