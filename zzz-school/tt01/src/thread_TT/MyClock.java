package thread_TT;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClock implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				Date nowDate = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				System.out.println(format.format(nowDate));
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}

	}

	public static void main(String[] args) {
		Thread thread = new Thread(new MyClock());
		thread.start();
		try {
			Thread.sleep(10 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
