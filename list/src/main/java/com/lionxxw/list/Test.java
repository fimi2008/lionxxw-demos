package com.lionxxw.list;

import java.util.ArrayList;
import java.util.List;

import com.lionxxw.beans.User;
import com.lionxxw.beans.User2;

public class Test {
	
	public static void main(String[] args) {
		User user = new User("1", "wang", "男");
		User user1 = new User("2", "wang2", "男");	
		User user2 = new User("3", "wang3", "男");
		List<User> list = new ArrayList<User>(3);
		list.add(user);
		list.add(user1);
		list.add(user2);
		
		/*User user4 = new User("1", "wang", "男");
		List<User> list2 = new ArrayList<User>();
		list2.add(user4);
		
		list.removeAll(list2);*/
		
		User2 b = new User2("1", "1", "1", "了1");
		User2 b2 = new User2("1", "2", "1", "了2");
		User2 b3 = new User2("1", "4", "1", "了4");
		User2 b4 = new User2("1", "5", "1", "了5");
		List<User2> list2 = new ArrayList<User2>(4);
		list2.add(b);
		list2.add(b2);
		list2.add(b3);
		list2.add(b4);
		
		list.removeAll(list2);
		
		System.out.println(list.toString());
		
		System.out.println("over");
	}
}
