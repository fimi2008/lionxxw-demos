package com.lionxxw.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lionxxw.jdbc.model.Goddess;
import com.lionxxw.jdbc.utils.DBUtil;

public class GoddessDao {
	
	public void add(Goddess goddess) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO goddess (userName, sex, age, birthday, email, mobile, createUser, createDate, isdel) VALUES(?, ?, ?, ?, ?, ?, ?, current_date(), 0)";
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, goddess.getUserName());
		prep.setInt(2, goddess.getSex());
		prep.setInt(3, goddess.getAge());
		prep.setDate(4, new Date(goddess.getBirthday().getTime()));
		prep.setString(5, goddess.getEmail());
		prep.setString(6, goddess.getMobile());
		prep.setString(7, goddess.getCreateUser());
		prep.execute();
	}
	
	public void update(Goddess goddess) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE goddess SET userName=?, sex=?, age=?, birthday=?, email=?, mobile=?, updateUser=?, updateDate=current_date() WHERE id = ?";
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, goddess.getUserName());
		prep.setInt(2, goddess.getSex());
		prep.setInt(3, goddess.getAge());
		prep.setDate(4, new Date(goddess.getBirthday().getTime()));
		prep.setString(5, goddess.getEmail());
		prep.setString(6, goddess.getMobile());
		prep.setString(7, goddess.getUpdateUser());
		prep.setInt(8, goddess.getId());
		prep.execute();
	}
	
	public void del(Integer id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE goddess SET isdel=1 WHERE id = ?";
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setInt(1, id);
		prep.execute();
	}

	public List<Goddess> query(Goddess params) throws Exception{
		Connection conn = DBUtil.getConnection();
		Statement st  = conn.createStatement();
		StringBuilder sql = new StringBuilder("select * from goddess where isdel = 0");
		
		if (null != params){
			if (null != params.getUserName() && !"".equals(params.getUserName().trim())){
				sql.append(" and userName like '%"+ params.getUserName() + "%'");
			}
			if (null != params.getMobile() && !"".equals(params.getMobile().trim())){
				sql.append(" and mobile like '%"+ params.getMobile().trim() + "%'");
			}
			if (null != params.getEmail() && !"".equals(params.getEmail().trim())){
				sql.append(" and email like '%"+ params.getEmail().trim() + "%'");
			}
		}
		
		ResultSet rs = st.executeQuery(sql.toString());
		
		List<Goddess> list = new ArrayList<Goddess>();
		Goddess goddess;
		while (rs.next()){
			goddess = new Goddess(rs.getInt("id"), rs.getString("userName"), rs.getInt("sex"),
					rs.getInt("age"), rs.getDate("birthday"), rs.getString("email"),
					rs.getString("mobile"), rs.getString("createUser"), rs.getDate("createDate"),
					rs.getString("updateUser"), rs.getDate("updateDate"), rs.getInt("isdel"));
			
			list.add(goddess);
		}
		return list;
	}
	
	public Goddess get(Integer id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "select * from goddess where isdel = 0 and id = ?";
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Goddess goddess = null;
		while (rs.next()){
			goddess = new Goddess(rs.getInt("id"), rs.getString("userName"), rs.getInt("sex"),
					rs.getInt("age"), rs.getDate("birthday"), rs.getString("email"),
					rs.getString("mobile"), rs.getString("createUser"), rs.getDate("createDate"),
					rs.getString("updateUser"), rs.getDate("updateDate"), rs.getInt("isdel"));
		}
		
		return goddess;
	}
}