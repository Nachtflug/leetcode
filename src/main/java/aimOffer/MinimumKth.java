package aimOffer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 面试题40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class MinimumKth {

    /**
     * 一般人能想到的大顶堆解发 O(nlogk)
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbersUsingHeap(int[] arr, int k) {

        int length = arr.length;
        if (k == length)
            return arr;
        if (k == 0)
            return new int[]{};
        int[] temp = new int[length];
        int pos = 0;
        if (k < length >> 1) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> (int) Math.signum(b * 1. - a));
            for (int i : arr) {
                if (heap.size() < k)
                    heap.add(i);
                else if (heap.peek() > i) {
                    heap.poll();
                    heap.add(i);
                }
            }
            for (Integer integer : heap) {
                temp[pos] = integer;
                pos++;
            }
        } else {  //找最大值
            int cap = length - k;
            PriorityQueue<Integer> heap = new PriorityQueue<>(cap);

            for (int i : arr) {
                if (heap.size() < cap)
                    heap.add(i);
                else if (heap.peek() < i) {
                    temp[pos] = heap.poll();
                    pos++;
                    heap.add(i);
                } else {
                    temp[pos] = i;
                    pos++;
                }
            }
        }

        return Arrays.copyOf(temp, pos);
    }

    /**
     * BFERT O(n)
     * 快排找到第K大的基准数时直接返回前K个值，BFERT优化了快排的过程
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == arr.length)
            return arr;
        if (k == 0)
            return new int[]{};
        innerBFPRT(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    /* 插入排序，返回中位数下标 */
    private static int insertionSort(int[] arr, int left, int right) {
        int temp, j;
        for (int i = left + 1; i <= right; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= left && arr[j] > temp)
                arr[j + 1] = arr[j--];
            arr[j + 1] = temp;
        }
        return ((right - left) >> 1) + left;
    }

    /* 返回中位数的中位数下标 */
    private static int getPivotIndex(int arr[], int left, int right) {
        if (right - left < 5)
            return insertionSort(arr, left, right);

        int subRight = left - 1, temp;
        for (int i = left; i + 4 <= right; i += 5) {
            int index = insertionSort(arr, i, i + 4);  //找到五个元素的中位数的下标
            swap(arr, index, ++subRight);//依次放在左侧
        }

        return innerBFPRT(arr, left, subRight, ((subRight - left + 1) >> 1) + 1);
    }

    private static void swap(int[] arr, int ia, int ib) {
        int temp = arr[ia];
        arr[ia] = arr[ib];
        arr[ib] = temp;
    }

    /* 利用中位数的中位数的下标进行划分，返回分界线下标 */
    private static int quickSortPartition(int[] arr, int left, int right, int pivotIndex) {
        swap(arr, pivotIndex, right);  //把基准放置于末尾

        int divideIndex = left;  //跟踪划分的分界线
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right])
                swap(arr, divideIndex++, i);  //比基准小的都放在左侧
        }

        swap(arr, divideIndex, right);  //最后把基准换回来
        return divideIndex;
    }

    private static int innerBFPRT(int[] arr, int left, int right, int k) {
        int pivotIndex = getPivotIndex(arr, left, right);            //得到中位数的中位数下标
        int divideIndex = quickSortPartition(arr, left, right, pivotIndex);  //进行划分，返回划分边界
        int num = divideIndex - left + 1;
        if (num == k)
            return divideIndex;
        else if (num > k)
            return innerBFPRT(arr, left, divideIndex - 1, k);
        else
            return innerBFPRT(arr, divideIndex + 1, right, k - num);
    }

}
