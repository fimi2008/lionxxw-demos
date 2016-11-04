package com.lionxxw.thread;

public class KeyPerson extends Thread{
	
	@Override
	public void run() {
		System.out.println(getName() + "开始战斗!");
		for (int i = 0; i < 10; i++ ){
			System.out.println(getName() + "战场搅屎棍~~~["+i+"]");
		}
		System.out.println(getName() + "结束战斗!");
	}
}
