package optimization;

import java.util.HashMap;
import java.util.Map;

/**
 * 好吧时间没什么区别，10*10000条数据都是50ms左右
 * 
 * @author zcp
 *
 */
public class Map_Optimize {

	static Map<String, Object> context = new HashMap<>();

	public static void main(String[] args) {
		addData(context);
		long start = System.currentTimeMillis();
		int size = context.size();
		Map<String, Object> respMap = new HashMap<>();
		for (int i = 0; i < size; i++) {
			respMap.put(String.valueOf(i), ((Integer) context.get(String.valueOf(i))) + 1);
		}
		long end = System.currentTimeMillis();
		System.out.println("修改数据 " + size + " 条，耗时 " + (end - start) + "毫秒");
	}

	public static void addData(Map<String, Object> map) {
		long start = System.currentTimeMillis();
		int size = 100000;
		for (int i = 0; i < size; i++) {
			map.put(String.valueOf(i), i);
		}
		long end = System.currentTimeMillis();
		System.out.println("添加数据 " + size + " 条，耗时 " + (end - start) + "毫秒");
	}
}
