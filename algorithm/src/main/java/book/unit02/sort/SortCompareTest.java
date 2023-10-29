package book.unit02.sort;

import edu.princeton.cs.algs4.*;

/**
 * 测试各种排序算法的性能
 *
 * @author 22517
 */
public class SortCompareTest {
    public static double time(SortEnum sortType, Comparable[] arr) {
        Stopwatch time = new Stopwatch();
        switch (sortType) {
            case Shell:
                new ShellSort().sort(arr);
//            Shell.sort(arr);
                break;
            case Insertion:
                Insertion.sort(arr);
                break;
            case Selection:
                Selection.sort(arr);
                break;
            case Quick:
                Quick.sort(arr);
                break;
            case Merge:
                new MergeSort().sort(arr);
        }
        return time.elapsedTime();

    }

    /**
     * T次的平均耗时
     *
     * @param sortEnum
     * @param N        数组大小
     * @param T        重复次数
     * @return
     */
    public static double timeRandomInput(SortEnum sortEnum, int N, int T) {
        double totalTime = 0.0;
        Double[] arr = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++)
                arr[j] = StdRandom.uniform();
            totalTime += time(sortEnum, arr);
        }
        return totalTime;
    }

    public static void main(String[] args) {

        int arrSize = 5000;
        int countTime = 300;
        // 大数组（不知是否部分有序）： 归并 > 希尔 > 选择 > 插入
        System.out.println("选择排序：" + timeRandomInput(SortEnum.Selection, arrSize, countTime));
        System.out.println("插入排序：" + timeRandomInput(SortEnum.Insertion, arrSize, countTime));
        System.out.println("希尔排序：" + timeRandomInput(SortEnum.Shell, arrSize, countTime));
        System.out.println("归并排序：" + timeRandomInput(SortEnum.Merge, arrSize, countTime));

        // 500*30，归并 > 希尔 > 插入 > 选择
//        arrSize = 500;
//        countTime = 30;
//        System.out.println("选择排序：" + timeRandomInput(SortEnum.Selection, arrSize, countTime));
//        System.out.println("插入排序：" + timeRandomInput(SortEnum.Insertion, arrSize, countTime));
//        System.out.println("希尔排序：" + timeRandomInput(SortEnum.Shell, arrSize, countTime));
//        System.out.println("归并排序：" + timeRandomInput(SortEnum.Merge, arrSize, countTime));
    }

}
