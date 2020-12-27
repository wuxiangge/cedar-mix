package com.cedar.algorithm.sort.insertion;

/**
 * @author zhangnan
 * @date 2020-11-15 16:19
 */
public class InsertionSort {

    private InsertionSort() {
    }

    /**
     * array[0...i] 已经排序
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void sortV2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }


    private static void swap(int[] data, int low, int high) {
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
    }
}
