package book.unit02.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * O(N) = 1+2+3+...+N = N<sup>2<sup/>
 */
public class SelectSort implements Sortable {

    public double sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (less(arr[j], arr[minIndex]))
                    minIndex = j;
            }
            exchange(arr, i, minIndex);
        }
        return 0;
    }

    public static void main(String[] args) {
        SelectSort selection = new SelectSort();

        int N = 100;
        Double[] arr = new Double[N];
        for (int j = 0; j < N; j++)
            arr[j] = StdRandom.uniform();
        System.out.println("有序：" + selection.isSorted(arr));
        System.out.println(Arrays.toString(arr));
        selection.sort(arr);
        System.out.println("有序：" + selection.isSorted(arr));
        System.out.println(Arrays.toString(arr));
    }
}
