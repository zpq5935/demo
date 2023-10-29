package book.unit02.sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * 插入排序适用于已经有部分数据已经排好，并且排好的部分越大越好。一般在输入规模大于1000的场合下不建议使用插入排序
 */
public class InsertSort implements Sortable {

    @Override
    public double sort(Comparable[] array) {
        Stopwatch timer = new Stopwatch();
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
        return timer.elapsedTime();
    }

    /**
     * 使用哨兵的插入排序
     */
    public double sortBySentry(Comparable[] array) {
        Stopwatch timer = new Stopwatch();
        int length = array.length;
        int minIndex = 0;
        for (int i = 1; i < length; i++) {
            minIndex = less(array[i], array[minIndex]) ? i : minIndex;
        }
        exchange(array, 0, minIndex);
        for (int i = 1; i < length; i++) {
            for (int j = i; less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        int N = 10000;
        InsertSort insertSort = new InsertSort();
        Double[] arr = new Double[N];
        double tottalTime = 0.0;
        double tottalTime2 = 0.0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < N; j++)
                arr[j] = StdRandom.uniform();
            Double[] copyOf = Arrays.copyOf(arr, arr.length);
            //
            tottalTime2 += insertSort.sortBySentry(copyOf);
            tottalTime += insertSort.sort(arr);
        }
        System.out.println("普通："+tottalTime);
        System.out.println("哨兵："+tottalTime2);
    }
}
