package com.lionxxw.thread.box;

public class Test {
	public static final int BOX_AMOUNT = 100;			// 将要构建的能量世界中能量盒子数量
	public static final double INITIAL_ENERGY = 1000;	// 每个盒子初始能量
	
	public static void main(String[] args) {
		EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
		for (int i = 0; i < BOX_AMOUNT; i++){
			EnergyTransferTask task = new EnergyTransferTask(eng, i, INITIAL_ENERGY);
			Thread t = new Thread(task, "ThansferThread_" + i);
			t.start();
		}
	}
}
