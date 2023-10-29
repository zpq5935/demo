package book.unit02.sort;

/**
 * 排序算法规范
 *
 * @author 22517
 */
public interface Sortable {
    @SuppressWarnings("rawtypes")
    default void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    default boolean less(Comparable left, Comparable right) {
        return left.compareTo(right) < 0;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    default boolean isSorted(Comparable[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++)
            if (less(array[i], array[i - 1]))
                return false;
        return true;
    }

    double sort(Comparable[] array);
}
