package com.lsrobot;

/**
 * 九九乘法表
 */
public class Multiplication {
    public static void main(String[] args) {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j <= i; j++) {
                //横坐标
                System.out.print(j + "x" + i + "=" + (j*i) + " ");
            }
            //每纵坐标换一行
            System.out.println();
        }
    }
}
