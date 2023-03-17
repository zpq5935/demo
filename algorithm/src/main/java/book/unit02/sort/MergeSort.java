package book.unit02.sort;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * 归并排序
 * 速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列
 */
public class MergeSort implements Sortable {

    @Override
    public double sort(Comparable[] array) {
        Comparable[] clone = new Comparable[array.length];
        Stopwatch timer = new Stopwatch();
        sort(array, clone, 0, array.length - 1);
        return timer.elapsedTime();

    }

    private void sort(Comparable[] array, Comparable[] clone, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            sort(array, clone, lo, mid);
            sort(array, clone, mid + 1, hi);
            merge(array, clone, lo, mid, hi);
        }
    }

    private void merge(Comparable[] array, Comparable[] clone, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            clone[i] = array[i];


        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = clone[j++];
            } else if (j > hi) {
                array[k] = clone[i++];
            } else if (less(clone[i], clone[j])) {
                array[k] = clone[i++];
            } else {
                array[k] = clone[j++];

            }
        }
    }
}
