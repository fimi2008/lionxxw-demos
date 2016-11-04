package com.lionxxw.thread.box;

/**		
 * <p>Title: EnergyTransferTask </p>
 * <p>Description: 类描述:TODO</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月29日上午10:01:24
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class EnergyTransferTask implements Runnable {

	private EnergySystem energySystem; 	// 共享的能量世界
	private int fromBox; 				// 能量转移的源能量盒子下标
	private double maxAmount;			// 单次能量转移最大单元
	private int DELAY = 10;				// 最大休眠的时间(毫秒)
	
	public EnergyTransferTask(EnergySystem energySystem, int from, double max){
		this.energySystem = energySystem;
		this.fromBox = from;
		this.maxAmount = max;
	}
	
	public void run() {
		try {
			while(true){
				int toBox = (int)(energySystem.getBoxAmount() * Math.random());
				double amount = maxAmount * Math.random();
				energySystem.transfer(fromBox, toBox, amount);
				Thread.sleep((int)(DELAY*Math.random()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
