package com.lionxxw.jdbc.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.lionxxw.jdbc.action.GoddessAction;
import com.lionxxw.jdbc.model.Goddess;

public class GoddessView {

	private static final String CONTEXT = "欢迎来到女神禁区:\n"
			+ "下面是女神禁区的功能列表:\n"
			+ "[MAIN/M]:主菜单\n"
			+ "[QUERY/Q]:查看全部女神的信息\n"
			+ "[GET/G]:查看某位女神的详细信息\n"
			+ "[ADD/A]:添加女神信息\n"
			+ "[UPDATE/U]:更新女神信息\n"
			+ "[DELETE/D]:删除女神信息\n"
			+ "[SEARCH/S]:查询女神信息(根据姓名,手机号码来查询)\n"
			+ "[EXIT/E]:退出女神禁区\n"
			+ "[BREAK/B]:退出当前功能,返回主菜单";
	
	private static final String OPERATION_MAIN = "MAIN";		// 主菜单
	private static final String OPERATION_QUERY = "QUERY";		// 查询所有
	private static final String OPERATION_GET = "GET";			// 女神详情
	private static final String OPERATION_ADD = "ADD";			// 新增
	private static final String OPERATION_UPDATE = "UPDATE";	// 修改女神
	private static final String OPERATION_DELETE = "DELETE";	// 删除女神
	private static final String OPERATION_SEARCH = "SEARCH";	// 查询女神
	private static final String OPERATION_EXIT = "EXIT";		// 退出
	private static final String OPERATION_BREAK = "BREAK";		// 返回主菜单
	
	private static String parent = null;	// 记忆父节点
	private static int step = 1;			// 操作步骤
	private static Goddess goddess = null;
	private static Scanner scan;
	
	public static void main(String[] args) {
		System.out.println(CONTEXT);
		scan = new Scanner(System.in);
		
		GoddessAction action = new GoddessAction();
		
		// 保持程序一直运行
		while (true){
			String in = scan.next().toString();
			if (OPERATION_EXIT.equalsIgnoreCase(in)|| OPERATION_EXIT.substring(0, 1).equalsIgnoreCase(in)){
				break;
			}else if (OPERATION_MAIN.equalsIgnoreCase(in)|| OPERATION_MAIN.substring(0, 1).equalsIgnoreCase(in) || OPERATION_BREAK.equalsIgnoreCase(in)|| OPERATION_BREAK.substring(0, 1).equalsIgnoreCase(in)){
				System.out.println(CONTEXT);
				parent = null;
				step = 1;
			}else if (OPERATION_ADD.equalsIgnoreCase(in)|| OPERATION_ADD.substring(0, 1).equalsIgnoreCase(in) || OPERATION_ADD.equals(parent)){
				add(action, in);
			}else if (OPERATION_UPDATE.equalsIgnoreCase(in)|| OPERATION_UPDATE.substring(0, 1).equalsIgnoreCase(in) || OPERATION_UPDATE.equals(parent)){
				update(action, in);
			}else if (OPERATION_QUERY.equalsIgnoreCase(in)|| OPERATION_QUERY.substring(0, 1).equalsIgnoreCase(in)){
				query(action);
			}else if (OPERATION_DELETE.equalsIgnoreCase(in)|| OPERATION_DELETE.substring(0, 1).equalsIgnoreCase(in) || OPERATION_DELETE.equals(parent)){
				del(action, in);
			}else if (OPERATION_GET.equalsIgnoreCase(in)|| OPERATION_GET.substring(0, 1).equalsIgnoreCase(in) || OPERATION_GET.equals(parent)){
				get(action, in);
			}else if (OPERATION_SEARCH.equalsIgnoreCase(in)|| OPERATION_SEARCH.substring(0, 1).equalsIgnoreCase(in) || OPERATION_SEARCH.equals(parent)){
				search(action, in);
			}
			
		}
		System.out.println("很遗憾!你不再获得女神的眷恋~");
	}

	private static void search(GoddessAction action, String in) {
		parent = OPERATION_SEARCH;
		switch (step) {
		case 1:
			goddess = new Goddess();
			System.out.println("请输入女神的[姓名]");
			break;
		case 2:
			goddess.setUserName(in);
			System.out.println("请输入女神的[手机号码]");
			break;
		case 3:
			goddess.setMobile(in);
			try {
				List<Goddess> list = action.query(goddess);
				if (null != list && list.size() > 0){
					for (Goddess g : list){
						System.out.println(g.getId() + "、" + g.getUserName());
					}
				}else{
					System.out.println("未查到相关信息");
				}
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println("查询失败~");
			}finally{
				step = 0;
				goddess = null;
			}
			break;
		default:
			break;
		}
		step++;
	}

	private static void update(GoddessAction action, String in) {
		parent = OPERATION_UPDATE;
		switch (step) {
		case 1:
			goddess = new Goddess();
			System.out.println("请输入女神的[序号]");
			break;
		case 2:
			goddess.setId(Integer.valueOf(in));;
			System.out.println("请输入女神的[姓名]");
			break;
		case 3:
			goddess.setUserName(in);
			System.out.println("请输入女神的[年龄]");
			break;
		case 4:
			goddess.setAge(Integer.valueOf(in));
			System.out.println("请输入女神的[生日],格式如: yyyy-MM-dd");
			break;
		case 5:
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				goddess.setBirthday(sf.parse(in));
				System.out.println("请输入女神的[邮箱]");
			} catch (ParseException e) {
//				e.printStackTrace();
				System.err.println("您输入的格式有误,请重新输入");
				step = 3;
			}
			break;
		case 6:
			goddess.setEmail(in);
			System.out.println("请输入女神的[手机号]");
			break;
		case 7:
			goddess.setMobile(in);
			try {
				action.add(goddess);
				System.out.println("新增女神成功~");
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println("新增女神失败~");
			}finally{
				step = 0;
				goddess = null;
			}
			break;
		default:
			break;
		}
		step++;
	}

	private static void get(GoddessAction action, String in) {
		parent = OPERATION_GET;
		switch (step){
		case 1:
			System.out.println("请输入查看女神的[序号]");
			break;
		case 2:
			try {
				Goddess g = action.get(Integer.valueOf(in));
				System.out.println("姓名:" + g.getUserName());
				System.out.println("年龄:" + g.getAge());
				System.out.println("生日:" + g.getBirthday());
				System.out.println("邮箱:" + g.getEmail());
				System.out.println("手机号码:" + g.getMobile());
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println("查询失败~");
			}finally{
				step = 0;
				parent = null;
			}
			break;
		}
		step++;
	}

	private static void del(GoddessAction action, String in) {
		parent = OPERATION_DELETE;
		switch (step){
		case 1:
			System.out.println("请输入需要删除女神的[序号]");
			break;
		case 2:
			try {
				action.del(Integer.valueOf(in));
				System.out.println("删除成功~");
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println("删除失败~");
			}finally{
				step = 0;
				parent = null;
			}
			break;
		}
		step++;
	}

	private static void query(GoddessAction action) {
		try {
			List<Goddess> query = action.query(null);
			for (Goddess g : query){
				System.out.println(g.getId() + "、" + g.getUserName());
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("查询出错~");
		}
		
	}

	private static void add(GoddessAction action, String in) {
		parent = OPERATION_ADD;
		switch (step) {
		case 1:
			goddess = new Goddess();
			System.out.println("请输入女神的[姓名]");
			break;
		case 2:
			goddess.setUserName(in);
			System.out.println("请输入女神的[年龄]");
			break;
		case 3:
			goddess.setAge(Integer.valueOf(in));
			System.out.println("请输入女神的[生日],格式如: yyyy-MM-dd");
			break;
		case 4:
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				goddess.setBirthday(sf.parse(in));
				System.out.println("请输入女神的[邮箱]");
			} catch (ParseException e) {
//				e.printStackTrace();
				System.err.println("您输入的格式有误,请重新输入");
				step = 3;
			}
			break;
		case 5:
			goddess.setEmail(in);
			System.out.println("请输入女神的[手机号]");
			break;
		case 6:
			goddess.setMobile(in);
			try {
				action.add(goddess);
				System.out.println("新增女神成功~");
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println("新增女神失败~");
			}finally{
				step = 0;
				goddess = null;
			}
			break;
		default:
			break;
		}
		step++;
	}
}
