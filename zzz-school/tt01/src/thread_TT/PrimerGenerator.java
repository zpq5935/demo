package thread_TT;

public class PrimerGenerator extends Thread {
	private long num;

	public PrimerGenerator(long num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (true) {
			if (isPrimer(num)) {
				System.out.println("Primer: " + num);
			}
			if (interrupted()) {
				System.out.printf("Thread: %s has benn interrupted\n", getName());
				return;
			}
			num++;
		}

	}

	/**
	 * 判断是否是质数
	 * 
	 * @param num2
	 * @return
	 */
	private boolean isPrimer(long num2) {
		if (0 == num2 % 2) {
			return true;
		} else {
			for (int i = 3; i <= num2 / 2; i++) {
				if (0 == num2 % i)
					return true;
			}
			return false;
		}

	}

	public static void main(String[] args) {
		Thread thread = new PrimerGenerator(2);
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		thread.interrupt();

	}
}
