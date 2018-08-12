package com.zhouyajun.SortingBasic;


/**
 * 插入排序，近乎有序的数组，效率会很高
 */
public class InsertionSort {


    public static void insertSort(int[] arr) {
        // 从第二个元素开始考察
        for (int i = 1; i < arr.length; i++) {
            // 把当前元素和前面的元素进行比较，如果小于前面的元素，则交换位置，如果大于则结束内层循环，进行外层循环
            // j>0，只能比较到第二个元素
//            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    SortTestHelper.swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
            // 交换操作也会占用很长时间，所以性能并不比选择排序高
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                SortTestHelper.swap(arr, j, j - 1);
            }
        }
    }

    public static void insertSortV2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找元素arr[i]合适的插入位置
            int e = arr[i];
            int j; // j保存元素e应该插入的位置
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray(100000, 34, 100);
        InsertionSort.insertSort(arr);
        SortTestHelper.testSort("com.zhouyajun.SortingBasic.InsertionSort", "insertSort", arr);
        SortTestHelper.testSort("com.zhouyajun.SortingBasic.InsertionSort", "insertSortV2", arr);
    }
}
