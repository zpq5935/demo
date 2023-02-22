package thread_TT;

public class Thread_TT1 implements Runnable {
	int[] arr = { 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300 };
	int num = arr.length;
	boolean[] flags = new boolean[arr.length];

	@Override
	public void run() {
		//synchronized (this) {
			while (num > 0) {
				int index = (int) (Math.random() * arr.length);
				if (flags[index])
					continue;
				flags[index] = true;
				System.out.println(Thread.currentThread().getName() + " 金额:" + arr[index]);
				num--;
			}
		//}
	}

	public static void main(String[] args) {
		Thread_TT1 thread_TT1 = new Thread_TT1();
		new Thread(thread_TT1, "----------奖金池1").start();
		new Thread(thread_TT1, "奖金池2----------").start();
	}
}
