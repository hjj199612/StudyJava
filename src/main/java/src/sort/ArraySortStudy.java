package src.sort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Description: 数组排序
 * @Author: huangjj24
 * @CreateDate: 2021-4-13 11:07
 **/
public class ArraySortStudy {

    static int[] arr;

    static {
        int count = (int) ((1 + Math.random()) * 1000);
        arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = (int) (Math.random() * 200);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getArr() {
        return arr.clone();//浅拷贝
    }

    public static void main(String[] args) {
        //冒泡排序 时间复杂度O(n2)   空间复杂度O(1)
        int[] bubbleArr = getArr();
        LocalDateTime start = LocalDateTime.now();
        bubbleSort(bubbleArr);
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("冒泡排序耗时:" + duration.toNanos() + "纳秒");
        System.out.println(Arrays.toString(bubbleArr));

        //插入排序 时间复杂度O(n2)   空间复杂度O(1)
        int[] insertArr = getArr();
        start = LocalDateTime.now();
        insertSort(insertArr);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("插入排序耗时:" + duration.toNanos() + "纳秒");
        System.out.println(Arrays.toString(insertArr));

        //选择排序 时间复杂度O(n2)   空间复杂度O(1)
        int[] selectArr = getArr();
        start = LocalDateTime.now();
        selectSort(selectArr);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("选择排序耗时:" + duration.toNanos() + "纳秒");
        System.out.println(Arrays.toString(selectArr));

        //希尔排序 时间复杂度O(n2)   空间复杂度O(1)
        int[] shellArr = getArr();
        start = LocalDateTime.now();
        shellSort(shellArr);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("希尔排序耗时:" + duration.toNanos() + "纳秒");
        System.out.println(Arrays.toString(shellArr));

        //快速排序 时间复杂度O(nlog2n)   空间复杂度O(logn)
        int[] quickArr = getArr();
        start = LocalDateTime.now();
        quickSort(quickArr);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("快速排序耗时:" + duration.toNanos() + "纳秒");
        System.out.println(Arrays.toString(quickArr));

        //归并排序 时间复杂度O(nlog2n)   空间复杂度O(n)
        int[] mergeArr = getArr();
        start = LocalDateTime.now();
        mergeSort(mergeArr);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("归并排序耗时:" + duration.toNanos() + "纳秒");
        System.out.println(Arrays.toString(mergeArr));

        //堆排序 时间复杂度O(nlog2n)   空间复杂度O(n)
        int[] heapArr = getArr();
        start = LocalDateTime.now();
        heapSort(heapArr);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("堆排序耗时:" + duration.toNanos() + "纳秒");
        System.out.println(Arrays.toString(heapArr));

        for (int i = 0; i < arr.length; i++) {
            if (bubbleArr[i] != selectArr[i] || bubbleArr[i] != insertArr[i]) {
                System.out.println("bubbleArr" + "不对劲");
                break;
            }
            if (insertArr[i] != bubbleArr[i]) {
                System.out.println("insertArr" + "不对劲");
                break;
            }
            if (selectArr[i] != bubbleArr[i]) {
                System.out.println("selectArr" + "不对劲");
                break;
            }
            if (shellArr[i] != bubbleArr[i]) {
                System.out.println("shellArr" + "不对劲");
                break;
            }
            if (quickArr[i] != bubbleArr[i]) {
                System.out.println("quickArr" + "不对劲");
                break;
            }
            if (mergeArr[i] != bubbleArr[i]) {
                System.out.println("mergeArr" + "不对劲");
                break;
            }
            if (heapArr[i] != bubbleArr[i]) {
                System.out.println("heapArr" + "不对劲");
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {//交换
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {//冒泡排序
    }

    public static void insertSort(int[] arr) {//插入排序
    }

    public static void selectSort(int[] arr) {//选择排序
    }

    public static void shellSort(int[] arr) {//希尔排序
    }

    public static void quickSort(int[] arr) {//快速排序
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {//快速排序递归调用
    }


    public static void mergeSort(int[] arr) {//归并排序 时间复杂度O(nlog2n)   空间复杂度O(n)
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
    }

    public static void heapSort(int[] arr) {//堆排序 时间复杂度O(nlog2n)   空间复杂度O()
    }

    private static void heapSort(int[] arr, int i, int length) {
    }

}

