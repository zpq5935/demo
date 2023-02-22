package algorithm;

import java.util.Random;

import com.sun.prism.j2d.J2DPipeline;

/**
 * 来源：https://www.cnblogs.com/wupeixuan/p/8654026.html 基础冒泡排序及优化
 * 
 * @author zcp
 *
 */
public class BubbleSort {

	public static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (array.length == i + 1)
				System.out.print(array[i]);
			else
				System.out.print(array[i] + ",");
		}
		System.out.print("]\n");
	}

	/**
	 * 基础冒泡排序
	 * 
	 * @param array
	 */
	public static void baseBubbleSort(int[] array) {
		System.out.println("--------------基础冒泡-------------------");
		System.out.print("原始数组：");
		// printArray(array);
		long startTime = System.currentTimeMillis();
		for (int j = array.length; j > 1; j--) {
			for (int i = 0; i < j - 1; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print("排序后：");
		// printArray(array);
		System.out.println("-->耗时：" + (endTime - startTime) + "\n-----------------\n");
	}

	/**
	 * 升级冒泡排序1<br>
	 * 对外层优化，若某次循环未交换数据，说明已是有序的，则停止循环
	 * 
	 * @param array
	 */
	public static void upV1_BubbleSort(int[] array) {
		System.out.println("--------------优化外层循环-------------------");
		System.out.print("原始数组：");
		// printArray(array);
		long startTime = System.currentTimeMillis();
		boolean flag = true;
		for (int j = array.length; j > 1; j--) {
			flag = true;
			for (int i = 0; i < j - 1; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print("排序后：");
		// printArray(array);
		System.out.println("-->耗时：" + (endTime - startTime) + "\n-----------------\n");
	}

	/**
	 * 升级冒泡排序2<br>
	 * 对外层优化，若某次循环未交换数据，说明已是有序的，则停止循环；<br>
	 * 优化内层，记住每次最后一个交换位置，以其为新的内层结束位置
	 * 
	 * @param array
	 */
	public static void upV2_BubbleSort(int[] array) {
		System.out.println("--------------优化外层+内层循环-------------------");
		System.out.print("原始数组：");
		// printArray(array);
		long startTime = System.currentTimeMillis();
		boolean flag = true;
		for (int j = array.length, j2 = array.length - 1; j > 1; j--) {
			flag = true;
			int j22 = j2;
			for (int i = 0; i < j22; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					flag = false;
					j2 = i;
				}
			}
			if (flag) {
				break;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print("排序后：");
		// printArray(array);
		System.out.println("-->耗时：" + (endTime - startTime) + "\n-----------------\n");
	}

	public static void main(String[] args) {
		int length = 10000;
		int[] array = new int[length];
		int[] array2 = new int[length];
		int[] array3 = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			array[i] = random.nextInt(length);
			array2[i] = random.nextInt(length);
			array3[i] = random.nextInt(length);
		}
		//
		baseBubbleSort(array);
		upV1_BubbleSort(array2);
		upV2_BubbleSort(array3);
	}
}
