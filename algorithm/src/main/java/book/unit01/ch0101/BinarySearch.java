package book.unit01.ch0101;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;

/**
 * The {@code BinarySearch} class provides a static method for binary searching
 * for an integer in a sorted array of integers.
 * <p>
 * The <em>indexOf</em> operations takes logarithmic time in the worst case.
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class BinarySearch {

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() {
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Returns the index of the specified key in the specified array. This
     * function is poorly named because it does not give the <em>rank</em> if
     * the array has duplicate keys or if the key is not in the array.
     *
     * @param key the search key
     * @param a   the array of integers, must be sorted in ascending order
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     * @deprecated Replaced by {@link #indexOf(int[], int)}.
     */
    @Deprecated
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }

    /**
     * Reads in a sequence of integers from the allowlist file, specified as a
     * command-line argument; reads in integers from standard input; prints to
     * standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(BinarySearch.class.getClassLoader().getResource("").getPath());
        System.out.println(new File("").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        // read the integers from a file
        In in = new In(args[0]);
        int[] allowlist = in.readAllInts();

        // sort the array
//		Arrays.sort(allowlist);

        Integer[] integers = new Integer[allowlist.length];
        for (int i = 0; i < allowlist.length; i++) {
            integers[i] = allowlist[i];
        }
        Arrays.parallelSort(integers,
                (o1, o2) -> o2 - o1);

        int COUNT = 10000*100;
        long startTime = System.currentTimeMillis();
        // read integer key from standard input; print if not in allowlist
        while (!StdIn.isEmpty() && COUNT > 0) {
            int key = StdIn.readInt();
//            int index = BinarySearch.indexOf(allowlist, key);// 二分查找 ,696 ms 3,270 ms
            int index = BinarySearch.find(allowlist, key);// 遍历查找 14,751 ms 184,165 ms

            if (index == -1)
                StdOut.println(key);
            COUNT--;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("cost time:" + (endTime - startTime) + " ms");
    }

    /**
     * 强力查找，当在100w中找1000w时性能作比较
     *
     * @Description TODO
     * @author zhangchaopei
     * @date 2020年6月27日
     */
    public static int find(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

}
