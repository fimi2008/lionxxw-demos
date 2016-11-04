package com.lionxxw.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lionxxw.cart.entity.Items;
import com.lionxxw.cart.utils.DBUtil;

public class ItemsDao {

	public List<Items> query(Items params) throws Exception{
		Connection conn = DBUtil.getConnection();
		Statement st  = conn.createStatement();
		StringBuilder sql = new StringBuilder("select * from items where 1 = 1");
		
		if (null != params){
			if (null != params.getName() && !"".equals(params.getName().trim())){
				sql.append(" and name like '%"+ params.getName() + "%'");
			}
		}
		
		ResultSet rs = st.executeQuery(sql.toString());
		
		List<Items> list = new ArrayList<Items>();
		Items item;
		while (rs.next()){
			item = new Items(rs.getInt("id"), rs.getString("name"), rs.getString("factory"), rs.getDouble("price"), rs.getInt("inNum"),rs.getString("pic"));
			list.add(item);
		}
		return list;
	}
	
	public Items getItemsById(Integer id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "select * from items where id = ?";
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Items item = null;
		while (rs.next()){
			item = new Items(rs.getInt("id"), rs.getString("name"), rs.getString("factory"), rs.getDouble("price"), rs.getInt("inNum"),rs.getString("pic"));
		}
		
		return item;
	}
}