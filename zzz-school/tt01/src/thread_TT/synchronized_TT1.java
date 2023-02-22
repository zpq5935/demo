package thread_TT;

public class synchronized_TT1 implements Runnable {

	// 共享资源
	static  int i = 0;
	private int threadID;
	public Object o;

	public synchronized_TT1(int threadID, Object o) {
		this.threadID = threadID;
		this.o = o;
	}

	/**
	 * synchronized 修饰实例方法
	 */
	public void increase() {
		synchronized (o) {
			i++;
			System.out.println(this.threadID + " | " + i);
		}

	}

	@Override
	public void run() {
		while (i < 100) {
			// 余数为0-偶数
			if (this.threadID == 13 && ((i / 10) % 2) == 0)
				increase();
			// 余数为1-奇数
			if (this.threadID == 14 && ((i / 10) % 2) == 1)
				increase();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		new Thread(new synchronized_TT1(13, o)).start();
		new Thread(new synchronized_TT1(14, o)).start();

	}
}
