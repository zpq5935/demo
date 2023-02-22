package thread_TT;

public class DataSourceLoader implements Runnable {
	@Override
	public void run() {
		System.out.println("load begin...");
		try {
			Thread.sleep(3 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("load finsh.");

	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new DataSourceLoader());
		thread.start();
		thread.join();
		new Thread(() -> {
			System.out.println("函数式编程。。。");
		}).start();
		Thread.sleep(1000);
		System.out.println("Main Thread: Over");
	}
}
