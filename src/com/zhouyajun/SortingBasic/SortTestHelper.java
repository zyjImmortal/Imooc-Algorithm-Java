package com.zhouyajun.SortingBasic;

import java.lang.reflect.Method;
import java.util.Random;

public class SortTestHelper {
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return array;
    }

    public static void printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                builder.append(array[i]).append(", ");
            } else {
                builder.append(array[i]);
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static void testSort(String className, String methodName, int[] arr) {
        try {
            Class sortClass = Class.forName(className);
            Method sortMethod = sortClass.getMethod(methodName, int[].class);
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(7, 10, 20);
        SortTestHelper.printArray(array);
    }


}
