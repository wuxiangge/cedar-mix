package com.cedar.algorithm.sort.shell.v2;

/**
 * @author zhangnan
 * @date 2021/1/28 18:00
 */
public class ShellSort {


    private ShellSort() {

    }


    public static <E extends Comparable<? super E>> void sort(E[] data) {

        int h = data.length / 2;

        while (h >= 1) {


            // 对data[start,start+h,start+2h... ] 进行插入排序
            for (int i = h; i < data.length; i ++) {


                E ret = data[i];

                int j;

                for (j = i; j - h >= 0 && ret.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = ret;
            }

            h /= 2;
        }
    }

}
