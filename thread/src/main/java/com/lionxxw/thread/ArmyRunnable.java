package com.lionxxw.thread;

/**		
 * <p>Title: ArmyRunnable </p>
 * <p>Description: 类描述:军队线程, 模拟作战双方</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月28日下午4:36:16
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class ArmyRunnable implements Runnable{

	// volatile 保证了线程可以正确的读取其他线程写入的值
	// 可见性 ref JMM , happens-before原则
	volatile boolean keepRunning = true;

	public void run() {
		while (keepRunning){
			// 发送5连击
			for (int i=0; i<5; i++){
				System.out.println(Thread.currentThread().getName() + "发动攻击["+i+"]");	
				Thread.yield(); // 让出cpu处理时间,线程重新竞争
			}
		}
		
		System.out.println(Thread.currentThread().getName() + "结束战斗!");
	}
}