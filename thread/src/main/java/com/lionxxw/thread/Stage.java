package com.lionxxw.thread;

/**
 * <p>Title: Stage </p>
 * <p>Description: 类描述:大戏舞台</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月28日下午4:47:26
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class Stage extends Thread{
	
	@Override
	public void run() {
		System.out.println("welcome!~");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("开始~");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		ArmyRunnable ar = new ArmyRunnable();
		ArmyRunnable br = new ArmyRunnable();
		// 使用Runnable接口创建线程
		Thread a = new Thread(ar, "A军");
		Thread b = new Thread(br, "B军");
		
		// 启动线程.开始作战
		a.start();
		b.start();
		
		// 舞台线程休眠,大家专心观看军队厮杀
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("正在双方战斗胶着之际,一名勇士站了出来~~~~~~~~");
		
		KeyPerson xman = new KeyPerson();
		xman.setName("X-man");
		System.out.println("X-man 进入战场~");
		
		// 发送停战指令
		ar.keepRunning = false;
		br.keepRunning = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 历史由关键人物改变
		xman.start();
		
		// 所有线程等待xman线程执行完毕
		try {
			xman.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("战争结束~再见~");
		
		/*try {
			a.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
	
	public static void main(String[] args) {
		new Stage().start();
	}

}
