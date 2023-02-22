package tt01_01;

public class thread_tt implements Runnable {
	private int number = 0;

	@Override
	public void run() {
		try {
			pt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		thread_tt thread01 = new thread_tt();
		Thread t1 = new Thread(thread01, "线程一");
		System.out.println(t1.getPriority());
		t1.start();
		new Thread(thread01, "线程二愣子").start();
	}

	public synchronized void pt() throws InterruptedException {
		for (; number < 10; number++) {
			if (5 == number)
				Thread.currentThread().interrupt();
			System.out.println(Thread.currentThread().getName() + ":" + number);
		}
	}

}
