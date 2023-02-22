package thread_TT;

public class thread_tt2 {
	public static void main(String[] args) {

		new Thread(() -> System.out.println("线程 : 一")).start();
		new Thread(() -> System.out.println("线程 : 二")).start();
		new Thread(() -> System.out.println("线程 : 三")).start();
		new Thread(() -> System.out.println("线程 : 四")).start();
		new Thread(() -> System.out.println("线程 : 五")).start();
		new Thread(() -> System.out.println("线程 : 六")).start();
		new Thread(() -> System.out.println("线程 : 七")).start();
		new Thread(() -> System.out.println("线程 : 八")).start();
		new Thread(() -> System.out.println("线程 : 九")).start();
		new Thread(() -> System.out.println("线程 : 十")).start();

	}
}
