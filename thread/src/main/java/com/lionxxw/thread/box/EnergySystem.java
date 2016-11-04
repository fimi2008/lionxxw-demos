package com.lionxxw.thread.box;


/**		
 * <p>Title: EnergySystem </p>
 * <p>Description: 类描述:宇宙的能力系统:
 * 遵循能量守恒定律:能量不会凭空创生或消失,只会从一处转移到另一处
 * </p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2015年12月29日上午9:44:00
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class EnergySystem { 
	
	// 能量盒子,能量存储的地方
	private final double[] energyBoxes;
//	private Lock lock = new ReentrantLock();
	private final Object lockObj = new Object();
	
	/**
	 * @param n 能量盒子的数量
	 * @param initialEnergy	每个能量盒子初始含有的能量值
	 */
	public EnergySystem(int n, double initialEnergy){
		energyBoxes = new double[n];
		for (int i = 0; i< energyBoxes.length; i++){
			energyBoxes[i] = initialEnergy;
		}
	}
	
	/**
	 * 能量的转移,从一个盒子到另一个盒子
	 * @param from 能量源
	 * @param to	能量终点
	 * @param amount	能量值
	 * @author xiang_wang
	 * 2015年12月29日上午9:50:30
	 */
	public void transfer(int from, int to, double amount){
		synchronized (lockObj) {
			// while循环,保证条件不满足时任务都会被条件阻挡
			while(energyBoxes[from] < amount){
				try {
					lockObj.wait(); // 条件不满足,将当前线程放入Wait Set
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName());
			energyBoxes[from] -= amount;
			System.out.printf("从%d转移%10.2f单位能量到%d%n", from, amount, to);
			energyBoxes[to] += amount;
			System.out.printf("能量总和:%10.2f%n", getTotalEnergies());
			
			// 唤醒所有在lockObj对象上等待的线程
			lockObj.notifyAll();
		}
		
		/*lock.lock();
		try {
			if (energyBoxes[from] < amount){
				return;
			}
			System.out.println(Thread.currentThread().getName());
			energyBoxes[from] -= amount;
			System.out.printf("从%d转移%10.2f单位能量到%d%n", from, amount, to);
			energyBoxes[to] += amount;
			System.out.printf("能量总和:%10.2f%n", getTotalEnergies());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}*/
	}

	/**
	 * 获取能量世界的能量总和
	 * @return
	 * @author xiang_wang
	 * 2015年12月29日上午9:58:04
	 */
	public double getTotalEnergies() {
		double sum = 0;
		for (double amount : energyBoxes){
			sum += amount;
		}
		return sum;
	}
	
	/**
	 * 返回能量盒子的长度
	 * @return
	 * @author xiang_wang
	 * 2015年12月29日上午10:00:22
	 */
	public int getBoxAmount(){
		return energyBoxes.length;
	}
} 