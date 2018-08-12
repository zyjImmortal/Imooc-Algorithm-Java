package com.zhouyajun.SortingBasic;


/**
 * 空间换时间来提高算法运行时间
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 对数组array[l, r]的范围进行排序,注意是闭区间,
     *
     * @param l :表示当前数组的最左边的索引
     * @param r :表示当前数组最右边的索引
     */
    private static void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    /**
     * 数组的左右两半部分已排序好，把两部分进行归并操作
     *
     * @param array:当前待归并的数组
     * @param l：当前数组左边索引
     * @param mid：当前数组中间索引
     * @param r：当前数组最右边索引
     */
    private static void merge(int[] array, int l, int mid, int r) {
        // 辅助数组
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            // i-l是因为辅助数组中元素的位置相对于给定数组array中元素的位置有l个偏移
            aux[i - l] = array[i];
        }
        int i = l; //左边排序好的部分卡开始指针
        int j = mid + 1; //右边排序好部分开始指针
        // k指针，表示元素要存储的位置
        for (int k = l; k <= r; k++) {
            // 当左边小的数多，i增加的快，会超过mid，此时aux[i - l] < aux[j - l])这个判断条件会引发越界异常
            // 索引先增加索引合法性的判断
            if (i > mid) {
                array[k] = aux[j - l];
                j++;
            } else if (j > r) {
                array[k] = aux[i - l];
                i++;
                // 索引再l-r范围之内进行的操作
            } else if (aux[i - l] < aux[j - l]) {
                array[k] = aux[i - l];
                i++;
            } else {
                array[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int a = 3 / 2;
        System.out.println(a);
    }
}
