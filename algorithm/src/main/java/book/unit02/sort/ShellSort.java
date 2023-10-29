package book.unit02.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * h有序数组：任意间隔为h的元素组成的子数组都是有序的<br/>
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率<br/>
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位<br/>
 *
 * @author 22517
 */
public class ShellSort implements Sortable {
    public double sort(Comparable[] array) {
        int length = array.length;
        int h = 1;
        while (h < length / 3)
            h = h * 3 + 1;
        while (h >= 1) {
            for (int start = h; start < 2 * h; start++)
                for (int i = start; i < length; i += h) {
                    for (int j = i; j > (start - h) && less(array[j], array[j - h]); j -= h)
                        exchange(array, j, j - h);
                }
            h /= 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        int N = 100;
        ShellSort shellSort = new ShellSort();
        Double[] arr = new Double[N];
        for (int j = 0; j < N; j++)
            arr[j] = StdRandom.uniform();
        System.out.println("排序前：\n" + Arrays.toString(arr));
        shellSort.sort(arr);
        System.out.println(shellSort.isSorted(arr));
        System.out.println("排序后：\n" + Arrays.toString(arr));
    }
}
