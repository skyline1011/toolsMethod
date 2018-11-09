package com.lsrobot;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class MaoPaoTest {
    public static void main(String[] args) {
        int[] arr = {6,3,8,2,9,1};
        System.out.println("排序前：" + Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++) {//外循环控制循环次数
            for (int j = 0; j < arr.length-1-i; j++) {//内循环控制每轮循环多少次
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
