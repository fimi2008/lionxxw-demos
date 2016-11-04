package com.lionxxw.thread.addsub;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**		
 * <p>Title: FourThread </p>
 * <p>Description: 类描述:设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序。
 以下程序使用内部类实现线程，对j增减的时候没有考虑顺序问题。</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2016年1月22日上午10:45:34
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class FourThread{
	private int j;
	private Lock lock = new ReentrantLock();
	private  void add(){
		lock.lock();
		j++;
		System.out.println(Thread.currentThread().getName()+"add():"+j);
		lock.unlock();
	}
	private  void sub(){
		lock.lock();
		j--;
		System.out.println(Thread.currentThread().getName()+"sub():"+j);
		lock.unlock();
	}
	
	class Inc implements Runnable{
		public void run() {
			for (int i=0; i< 10; i++){
				add();
			}
		}
	}
	
	class Dec implements Runnable{
		public void run() {
			for (int i=0; i< 10; i++){
				sub();
			}
		}
	}
	
	public static void main(String[] args) {
		FourThread four = new FourThread();
		Inc inc = four.new Inc();
		Dec dec = four.new Dec();
		for (int i = 0; i< 2; i++){
			Thread t = new Thread(inc);
			t.start();
			t = new Thread(dec);
			t.start();
		}
	}
}