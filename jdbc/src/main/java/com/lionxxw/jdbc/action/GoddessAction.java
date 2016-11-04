package com.lionxxw.jdbc.action;

import java.util.Date;
import java.util.List;

import com.lionxxw.jdbc.dao.GoddessDao;
import com.lionxxw.jdbc.model.Goddess;

public class GoddessAction {
	
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		goddess.setSex(1);
		goddess.setCreateUser("王翔");
		dao.add(goddess);
	}
	
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.update(goddess);
	}
	
	public void del(Integer id) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.del(id);
	}

	public List<Goddess> query(Goddess params) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}
	
	public Goddess get(Integer id) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.get(id);
	}
	
	public static void main(String[] args) throws Exception {
		GoddessDao dao = new GoddessDao();
		Goddess goddess = new Goddess();
		goddess.setUserName("小美");
		goddess.setAge(34);
		goddess.setEmail("57469614@qq.com");
		goddess.setMobile("1547221");
		goddess.setSex(0);
		goddess.setUpdateUser("王翔");
		goddess.setBirthday(new Date());
		goddess.setId(2);
//		dao.add(goddess);
//		dao.update(goddess);
//		dao.del(2);
//		Goddess g = dao.get(1);
//		System.out.println(g);
		for (Goddess g : dao.query(goddess)){
			System.out.println(g.toString());
		}
	}
}