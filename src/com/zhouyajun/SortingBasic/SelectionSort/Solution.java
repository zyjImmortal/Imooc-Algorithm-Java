package com.zhouyajun.SortingBasic.SelectionSort;

import com.zhouyajun.SortingBasic.SortTestHelper;

/**
 * 选择排序：每次找出最小的元素放到数组的最前面
 * 缺点：两层循环全部都要执行一次，即使是近乎有序的数组
 */
public class Solution {

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * 思路：主要分两步进行
     * 1、找出最小元素
     * 2、和前面的元素进行交换
     * 扩展：自定义比较
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;  // 设定初始最小值索引为数组开始元素，每选择完一次累加
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 8, 5, 3, 9, 2, 0};
        Solution.selectionSort(array);
        SortTestHelper.printArray(array);
    }
}
